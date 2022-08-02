package com.example.springbootJpa.Controller;

import com.example.springbootJpa.Repository.UserRepository;
import com.example.springbootJpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUser(User user){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).orElseThrow(()->
                new IllegalStateException("user with id "+id+" does not exist"));
        return user;
    }

    @PostMapping("/user")
    public User saveOrUpdateUser(@RequestBody User user){
        return userRepository.save(user);

    }

//    @PutMapping(path = "/user/{id}")
//    @Transactional
//    public User updateUser(@PathVariable Integer id,String name, String email , String address ){
//
//    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        boolean exist = userRepository.existsById(id);
        if(!exist)
            throw new RuntimeException("User with id "+id+" not found");
        userRepository.deleteById(id);
        return null;
    }
}
