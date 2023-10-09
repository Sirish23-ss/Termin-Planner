package com.example.app;

import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Long> {
    public User findByUsername(String username);

    //User getByusername(String usaername);

}
