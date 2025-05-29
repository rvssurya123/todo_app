package com.surya.demo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // add user
    @PostMapping("/users")
    public int addUser(@RequestBody Map<String, String> user){
        int id = userService.createUser(user);
        System.out.println(id);
        return id;
    }
}
