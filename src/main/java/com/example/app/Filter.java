package com.example.app;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * A Designer generated component for the my-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */


@Route("Filter")
public class Filter extends VerticalLayout {






    Termin t;
    private List<Termin> termin ;
    Grid<Termin> grid = new Grid<>();
    Button button =new Button("Back");
     Button delete =new Button("Delete");

     Button search =new Button("Search");
    DatePicker date =new DatePicker("Enter date");



    HorizontalLayout hl = new HorizontalLayout(date,search);


    @Autowired
    Mycontroller my;

    /**
     * Creates a new MyView.
     */


    @Autowired
    public Filter(Mycontroller mycontroller) {
        add(hl);
        date.setValue(LocalDate.now());
        LocalDate f_date = date.getValue();
        termin=mycontroller.filter(f_date);
        search.addClickListener(event -> {

            //Notification.show(String.valueOf(date.getValue()));
          termin = mycontroller.filter(date.getValue());
          grid.getDataProvider().refreshAll();

        });


        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);




        button.addClickListener(event->{
            button.getUI().ifPresent(ui ->
                    ui.navigate("demo"));
        });


        add(maketable(termin));
        add(new HorizontalLayout(button,delete));
    }

    public Grid<Termin> maketable(List<Termin> termin){
        grid.setItems(termin);
        //grid.addColumn(Termin::getId).setHeader("ID");
        grid.addColumn(Termin::getT_date).setHeader("Date").setSortable(true);
        grid.addColumn(Termin::getT_time).setHeader("Time");
        grid.addColumn(Termin::getDes).setHeader("Description");
        grid.addComponentColumn(ter ->{
            Button bu =new Button("Remove",click -> {
                Notification.show("Termin remove Successfully.........");
                my.fun(ter);
                UI.getCurrent().getPage().reload();

                //grid.getDataProvider().refreshAll();
            });
            return bu;
        });
        grid.addComponentColumn(term -> {
            Button edit = new Button("Edit", click -> {

                VaadinSession.getCurrent().setAttribute(Termin.class,term);
                UI.getCurrent().navigate("edit");

            });
            return edit;
        });


        //Select multi grid from data..............................................................

        return grid;
    }


}
