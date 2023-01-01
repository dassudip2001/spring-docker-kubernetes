package com.example.cardoperationmysql.user;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardoperationmysql.user.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

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
    public List<User> getAllUser()
    {
        return repository.findAll();
    }
    // get user by id

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable int id)

    {
        return repository.findById(id);
        
    }

    // put the user
       // update
       @PutMapping("user/{id}")
       Optional<Object> updateUser(@RequestBody User newUser,@PathVariable int  id){
           return repository.findById(id)
           .map(user->{
               user.setEmail(newUser.getEmail());
               user.setName(newUser.getName());
               return repository.save(user);
           });
       }

    // delete User
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id)
    {
        if(!repository.existsById(id)){
            throw new UserNotFoundException(id);
         }
        repository.deleteById(id);
        return "User deleted successfully";
    }


}
