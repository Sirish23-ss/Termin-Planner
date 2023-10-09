package com.example.app;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

@Route("edit")
public class editPage  extends VerticalLayout {

    private DatePicker editDate= new DatePicker("Date");

    private TimePicker editTime= new TimePicker("Time");

     private TextArea editInfo = new TextArea("Info");

     private LocalDate date;
     private LocalTime time;
     private String des;

     Button save = new Button("Save");
     Button back = new Button("Back");
     //HorizontalLayout h1 = new HorizontalLayout();


      @Autowired
      public editPage(Mycontroller my){
          Termin termin= getdata();
          editDate.setMin(LocalDate.now());

         editDate.setValue(termin.getT_date());
         editTime.setValue(termin.getT_time());
         editInfo.setValue(termin.getDes());

          add(new HorizontalLayout(editDate,editTime));
          add (editInfo);
          add(new HorizontalLayout(save,back));

          back.addClickListener(click ->{
              UI.getCurrent().navigate("all_termin");
          });

          save.addClickListener(event ->{
              termin.setT_date(editDate.getValue());
              termin.setT_time(editTime.getValue());
              termin.setDes(editInfo.getValue());
              termin.setIn(getindex());
              //my.fun(termin);
              //my.add_termin(editDate.getValue(),editTime.getValue(),editInfo.getValue());
              //Notification.show("Appointment has been upadated successfully.....!");
              my.updateTermin(termin);


          });
      }

      public Termin getdata(){

          Termin t= VaadinSession.getCurrent().getAttribute(Termin.class);
          return t;

      }
      
      public Long getindex(){
          User user = VaadinSession.getCurrent().getAttribute(User.class);
          return user.getId();
      }

}
