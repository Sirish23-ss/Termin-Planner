package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * A Designer generated component for the filter-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("filt")
@JsModule("./filter-view.ts")
public class FilterView extends LitTemplate {

    @Id("filterTermin")
    private DatePicker filterTermin;
    @Id("vaadinButton")
    private Button vaadinButton;
    @Id("grid")
    private Grid grid;

    @Autowired
    Filter filt;


    private List<Termin> termin ;

    /**
     * Creates a new FilterView.
     */
    public FilterView(Mycontroller my) {
       vaadinButton.addClickListener(event -> {

           //Notification.show(String.valueOf(date.getValue()));
           termin =  my.filter(filterTermin.getValue());
           grid.getDataProvider().refreshAll();});

           grid= filt.maketable(termin);
    }

}
