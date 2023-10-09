package com.example.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.VaadinSession;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ADD_table {

    @Autowired
    dao d;

    @Autowired
    AppDao app;


    public MQTTData mqttData= new MQTTData();

    List<Termin> today_termin =new ArrayList<Termin>();

    List<Termin> future_termin =new ArrayList<Termin>();

    List<Termin> filter_date =new ArrayList<Termin>();
    LocalDate to_date = LocalDate.now();


    public void savetable(Termin t,Long index){
        try {
            for (Termin i : showTermin(index)) {
                if (i.getT_date().isEqual(t.getT_date())) {
                    if (i.getT_time() == t.getT_time()) {
                        throw new exception();

                    }

                }
            }
            d.save(t);
           // MQTTData mqttData;
            List<Termin> terminList=d.findByIndex(index);
            ObjectMapper o= new ObjectMapper();
            o.registerModule(new JavaTimeModule());
            String writer= o.writeValueAsString(terminList);
            System.out.println(writer);

           mqttData.mqttCall(writer,index);

            Notification.show("Done!");
        }

        catch (exception e){
            Notification.show(String.valueOf(e));
        } catch (MqttException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //d.save(t);

    }
    public List<Termin> showTermin(Long index) {
        return d.findByIndex(index);
    }

    public List<Termin> today(Long index){
        today_termin.clear();
        for (Termin i: showTermin(index)) {
            if(i.getT_date().isEqual(to_date)){
                today_termin.add(new Termin(i.getId(),i.t_date,i.t_time,i.des));
            }
        }
        return today_termin;
    }

    public List<Termin> future(Long index){
        future_termin.clear();
        for(Termin i: showTermin(index)){
            if(i.getT_date().isAfter(to_date) || i.getT_date().isEqual(to_date) ){
                future_termin.add(new Termin(i.getId(),i.t_date,i.t_time,i.des));
            }
        }
        return future_termin;

    }

    public void terminremove(Termin t){
        d.delete(t);
    }

    public void t_delete(Termin i){
        d.delete(i);
    }

    public List<Termin> fil(LocalDate fil_date, Long index){
        filter_date.clear();
        for (Termin i: showTermin(index)) {
            if(i.getT_date().isEqual(fil_date)){
                filter_date.add(new Termin(i.getId(),i.t_date,i.t_time,i.des));
            }

        }

        return filter_date;
    }


    /*public void app_save(Appointment a) {
        app.save(a);
        Notification.show("Done!");

    }

    public List<Appointment> show_app(Long l){
        return app.findByIndex(l);
    }*/

    public void update(Termin updatetermin,long id){
        //d.save(updatetermin);
        User user= VaadinSession.getCurrent().getAttribute(User.class);
        Long l= user.getId();
        try {
            for (Termin i : d.getAll(id)) {
                if(i.getIn() == l) {
                    if (i.getT_date().isEqual(updatetermin.getT_date())) {
                        if (i.getT_time() == updatetermin.getT_time()) {
                            throw new exception();

                        }

                    }
                }
            }
            d.save(updatetermin);
            Notification.show("Appointment has been updated successfully...!");
            //UI.getCurrent().navigate("all_termin");
            UI.getCurrent().getPage().getHistory().back();
        }

        catch (exception e){
            Notification.show(String.valueOf(e));
        }
    }
}
