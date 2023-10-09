package com.example.app;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * A Designer generated component for the my-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */


@Route("T_termin")
public class Today extends VerticalLayout {




    Termin t;
    private List<Termin> termin ;
    Grid<Termin> grid = new Grid<>();
    Button button =new Button("Back");
    Button delete =new Button("Delete");




    @Autowired
    Mycontroller m;

    /**
     * Creates a new MyView.
     */


    @Autowired
    public Today(@NotNull Mycontroller mycontroller) {
        termin=mycontroller.todayTermin();



        button.addClickListener(event->{
            button.getUI().ifPresent(ui ->
                    ui.navigate("demo"));
        });

        add(new H1("Today's Termin"));
        add(maketable(termin));
        add(button);
    }

    public Grid<Termin> maketable(List<Termin> termin){
        grid.setItems(termin);

        //grid.addColumn(Termin::getId).setHeader("ID");
        grid.addColumn(Termin::getT_date).setHeader("Date");
        grid.addColumn(Termin::getT_time).setHeader("Time").setSortable(true);
        grid.addColumn(Termin::getDes).setHeader("Description");

        grid.addComponentColumn(ter -> {
            Button btn =new Button("Remove", click ->{
                Notification.show("Termin remove Successfully.........");
                m.fun(ter);

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


        return grid;
    }

}
