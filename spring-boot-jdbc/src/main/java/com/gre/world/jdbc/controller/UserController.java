package com.gre.world.jdbc.controller;

import com.gre.world.jdbc.domain.User;
import com.gre.world.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 风骚的GRE
 * @Descriptions User Controller On WebMVC
 * @date 2018/8/19.
 */
@RestController
@RequestMapping("web/mvc/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/")
    public boolean save(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping(value = "/jdbcSave")
    public boolean jdbcSave(@RequestBody User user){
        return userRepository.jdbcSave(user);
    }

    @PostMapping(value = "/transactionalSave")
    public boolean transactionalSave(@RequestBody User user){
        return userRepository.transactionalSave(user);
    }

    @GetMapping(value = "/")
    public Collection<User> findAll(){
        return userRepository.findAll();
    }
}
