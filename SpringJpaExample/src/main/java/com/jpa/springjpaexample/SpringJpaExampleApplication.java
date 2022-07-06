package com.jpa.springjpaexample;

import com.jpa.springjpaexample.com.jpa.springjpaexample.doa.UserRepository;
import com.jpa.springjpaexample.com.jpa.springjpaexample.model.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaExampleApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRespository;

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaExampleApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

//        User user = new User();
//        user.setUsername("kunal");
//        user.setPassword("kunal");
//        user.setEmail("kunal@gmail.com");
//        this.userRespository.save(user);
//

    }
}
