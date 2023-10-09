
package com.example.app;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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


@Route("upcoming")
public class UpComing extends VerticalLayout {





    private List<Termin> termin ;
    Grid<Termin> grid = new Grid<>();
    Button button =new Button("Back");

    @Autowired
    Mycontroller con;

    /**
     * Creates a new MyView.
     */


    @Autowired
    public UpComing( Mycontroller mycontroller) {
        termin=mycontroller.futureTermin();



        button.addClickListener(event->{
            button.getUI().ifPresent(ui ->
                    ui.navigate("demo"));
        });

        add(new H1("Future's Termin"));
        add(maketable(termin));
        add(button);
    }

    public Grid<Termin> maketable(List<Termin> termin){
        grid.setItems(termin);


        grid.addColumn(Termin::getT_date).setHeader("Date").setSortable(true);
        grid.addColumn(Termin::getT_time).setHeader("Time");
        grid.addColumn(Termin::getDes).setHeader("Description");
        grid.addComponentColumn(ter ->{
           Button bu =new Button("Delete", event -> {
               con.fun(ter);
               UI.getCurrent().getPage().reload();

           }) ;
           return  bu;
        });
        grid.addComponentColumn(term -> {
            Button edit = new Button("Edit", click -> {

                VaadinSession.getCurrent().setAttribute(Termin.class,term);
                UI.getCurrent().navigate("edit");

            });
            return edit;
        });

        return grid;
    }

}
