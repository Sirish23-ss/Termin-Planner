package com.example.app;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("Signin")
public class SignIn extends VerticalLayout {



    public H1 tital= new H1("Sign-In Page");
    public TextField  username = new TextField("Set UserName");
    public PasswordField password = new PasswordField("Set Password");

    public Button  save= new Button("Save");

    @Autowired
    public SignIn(UserController userController){
        save.addClickListener(event -> {
           userController.add_user(username.getValue(),password.getValue());
        });

        add(tital,username,password,save);

    }
}
