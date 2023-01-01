package com.example.cardoperationmysql.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }


//    Post User or create user

    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        return repository.save(user);
    }

//    get all the user

    @GetMapping("/users")
    public List<User> getallUser()
    {
        return repository.findAll();
    }


}
