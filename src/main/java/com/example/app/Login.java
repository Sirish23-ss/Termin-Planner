package com.example.app;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class Login extends Composite<LoginOverlay> {
    @Autowired
    public   Login(UserController userController){
        LoginOverlay log =getContent();
        log.setOpened(true);
        log.setTitle("Termin Planner");
        log.setDescription("Add Your Appointments");

        log.addLoginListener(click -> {
            userController.login(click.getUsername(),click.getPassword());

        });

        log.addForgotPasswordListener(event->{
            log.getUI().ifPresent(ui ->
                    ui.navigate("Signin"));
        });
    }
}
