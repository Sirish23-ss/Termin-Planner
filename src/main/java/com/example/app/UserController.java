package com.example.app;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    UserRepo user_d;

    User userinfo;


    public UserController(UserRepo user_d) {
        this.user_d = user_d;
    }



    public void  add_user(String username, String password){

        user_d.save(new User(username,password));

    }




    public void login(String username, String pass)  {
        User user = user_d.findByUsername(username);

        userinfo=user;




        if(user != null && user.checkPassword(pass)){
            VaadinSession.getCurrent().setAttribute(User.class,user);
            UI.getCurrent().navigate("demo");
        } else {
            Notification.show("Bad Cridential.");
            UI.getCurrent().getPage().reload();
        }

        //String  UserName = user.getUsername();

        //Notification.show(UserName);


        /*if(UserName.equals(username)){
            Notification.show(UserName);
        }
        if(user.getPassword() == pass){
            Notification.show(user.getPassword());
        }*/



       /*if(username == null || pass == null){
            Notification.show("Please Enter details");
        }else {
            //user = user_d.getByUsername(username);
             //User user = user_d.findByUsername(username);
            if(user == null){
                Notification.show("User Not Found");
            } else{
                if(user.getUsername().equals(username) && user.getPassword().equals(pass)){
                    UI.getCurrent().navigate("Filter");
                  // new RouterLink("Filter",Filter.class);
                }
                else{
                    Notification.show("Bad Cridentials");
                }
            }

        }*/



    }

    public User getUser(){
        return userinfo;
    }
}
