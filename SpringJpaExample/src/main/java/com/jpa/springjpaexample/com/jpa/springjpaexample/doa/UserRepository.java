package com.jpa.springjpaexample.com.jpa.springjpaexample.doa;

import com.jpa.springjpaexample.com.jpa.springjpaexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    public User findById(int id);
}
