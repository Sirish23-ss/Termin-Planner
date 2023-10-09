package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * A Designer generated component for the demo-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("demo-view")
@JsModule("./demo-view.ts")
@Route("/demo")
public class DemoView extends LitTemplate {

    @Id("Termin_date")
    private DatePicker termin_date;
    @Id("Termin_time")
    private TimePicker termin_time;
    @Id("Text_me")
    private TextArea text_me;
    @Id("Save")
    private Button save;
    @Id("all")
    private Button all;
    @Id("Today")
    private Button today;
    @Id("Upcoming")
    private Button upcoming;
    @Id("filter")
    private Button filter;
    @Id("login")
    private Button login;


    /**
     * Creates a new DemoView.
     *
     */
    @Autowired
    public DemoView( Mycontroller myController) {

        termin_date.setMin(LocalDate.now());

        save.addClickListener(event -> {
            if(termin_date.getValue() == null ||termin_time.getValue() ==null || text_me.getValue() == null || text_me.isEmpty() ){
                Notification.show("Enter Date, Time and Description.");
            } else {
                myController.add_termin(termin_date.getValue(), termin_time.getValue(), text_me.getValue());

                termin_date.clear();
                termin_time.clear();
                text_me.clear();

            }
        });




        all.addClickListener(event->{
            all.getUI().ifPresent(ui ->
                    ui.navigate("all_termin"));
        });

        filter.addClickListener(event->{
            filter.getUI().ifPresent(ui ->
                    ui.navigate("Filter"));
        });
        today.addClickListener(event->{
            today.getUI().ifPresent(ui ->
                    ui.navigate("T_termin"));
        });

        upcoming.addClickListener(event->{
            upcoming.getUI().ifPresent(ui ->
                    ui.navigate("upcoming"));
        });
        login.addClickListener(event->{
            login.getUI().ifPresent(ui ->
                    ui.navigate(""));
        });




    }

}
