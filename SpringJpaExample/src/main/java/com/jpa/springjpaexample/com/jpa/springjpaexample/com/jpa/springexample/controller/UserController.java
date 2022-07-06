package com.jpa.springjpaexample.com.jpa.springjpaexample.com.jpa.springexample.controller;

import com.jpa.springjpaexample.com.jpa.springjpaexample.com.jpa.springjpaexample.services.UserService;
import com.jpa.springjpaexample.com.jpa.springjpaexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list=userService.getAllUsers();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user=userService.getById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(user));

    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u=null;
        try{
            u=userService.addUser(user);
            System.out.println(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(u);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        try{
            this.userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") int id){
        try{
            this.userService.updateUser(user,id);
            return ResponseEntity.ok().body(user);
        }
        catch( Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
