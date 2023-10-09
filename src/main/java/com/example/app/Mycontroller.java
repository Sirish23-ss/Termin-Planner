package com.example.app;

import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class Mycontroller {

    @Autowired
    public  ADD_table add;

    public List<Termin> my=null;

    public LocalDate d_date=null;
    public LocalTime d_Time =null;






    public  void  add_termin(LocalDate t_date, LocalTime t_time, String description)  {

            Termin t= new Termin(t_date,t_time,description,getIndex());

            add.savetable(t,getIndex());

    }

    public List<Termin> getTermin(){

        return add.showTermin(getIndex());
    }

    public List<Termin> todayTermin(){

        return add.today(getIndex());
    }

    public List<Termin> futureTermin(){

        return add.future(getIndex());

    }

    public void delete (Set<Termin> t1){
        for(Termin i: t1){
            add.terminremove(i);
        }


    }

    public void fun (Termin t){
        add.t_delete(t);
    }

    public List<Termin> filter(LocalDate date){
        return add.fil(date,getIndex());
    }

   /* public void add_app(LocalDate dateValue, LocalTime timeValue, String description) {
      // User user= VaadinSession.getCurrent().getAttribute(User.class);
       //Long index = user.getId();
       //String S1 = String.valueOf(index);

       Appointment a= new Appointment(dateValue,timeValue,description,getIndex());

       add.app_save(a);

    }

    public List<Appointment> app_show(){

        return add.show_app(getIndex());

    }*/

    public  void updateTermin(Termin termin){

        add.update(termin, termin.getId());
    }

    public Long getIndex(){
        User user= VaadinSession.getCurrent().getAttribute(User.class);
        Long index = user.getId();
        return index;
    }
}
