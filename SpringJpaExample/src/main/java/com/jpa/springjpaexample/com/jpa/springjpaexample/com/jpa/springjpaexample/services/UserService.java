package com.jpa.springjpaexample.com.jpa.springjpaexample.com.jpa.springjpaexample.services;

import com.jpa.springjpaexample.com.jpa.springjpaexample.doa.UserRepository;
import com.jpa.springjpaexample.com.jpa.springjpaexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> list = (List<User>) this.userRepository.findAll();
        return list;

    }

    public User getById(int id) {
        User user=null;
        try {
            user=this.userRepository.findById(id);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public User addUser(User user){
        User result=this.userRepository.save(user);
        return result;

    }
    public void deleteUser(int uid){
        this.userRepository.deleteById(uid);

    }
    public void updateUser(User user ,int userId){
        user.setId(userId);
        userRepository.save(user);
    }
}
