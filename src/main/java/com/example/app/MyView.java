package com.example.app;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.MultiSelect;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * A Designer generated component for the my-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */


@Route("all_termin")
public class MyView extends VerticalLayout {






    //Termin ;
    private List<Termin> termin ;
    Grid<Termin> grid = new Grid<>();
    Button button =new Button("Back");
    Button delete =new Button("Delete");

    //Button edit = new Button("Edit");

    MultiSelect<Grid<Termin>, Termin> selection;

    @Autowired
    Mycontroller my;

    //@Autowired
    editPage editpage;

    /**
     * Creates a new MyView.
     */


    @Autowired
    public MyView(Mycontroller mycontroller) {
        termin=mycontroller.getTermin();



        button.addClickListener(event->{
            button.getUI().ifPresent(ui ->
                    ui.navigate("demo"));
        });

        add(new H1("Termin"));
        add(maketable(termin));
        add(new HorizontalLayout(button,delete));
    }

    public Grid<Termin> maketable(List<Termin> app){
        grid.setItems(app);


        //grid.addColumn(Termin::getId).setHeader("ID");
        //grid.addColumn(Appointment::getDate).setHeader("Date").setSortable(true);
        //grid.addColumn(Appointment::getTime).setHeader("Time");
        //grid.addColumn(Appointment::getDescription).setHeader("Description");
       grid.addColumn(Termin::getT_date).setHeader("Date").setSortable(true);
        grid.addColumn(Termin::getT_time).setHeader("Time");
        grid.addColumn(Termin::getDes).setHeader("Description");
        grid.addComponentColumn(ter -> {
           Button btn =new Button("Remove", click ->{
               Notification.show("Termin remove Successfully.........");
               my.fun(ter);
               UI.getCurrent().getPage().reload();
           });

           return btn;
        });

        grid.addComponentColumn(term -> {
            Button edit = new Button("Edit", click -> {

                VaadinSession.getCurrent().setAttribute(Termin.class,term);
                UI.getCurrent().navigate("edit");

            });
            return edit;
        });

        //Select multi grid from data..............................................................
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        selection =grid.asMultiSelect();
        delete.addClickListener(event->{
           //Notification.show(String.valueOf(selection.getSelectedItems()));
           my.delete(selection.getSelectedItems());
            UI.getCurrent().getPage().reload();
        });
        /*..........................................................................................*/

        return grid;
    }


}
