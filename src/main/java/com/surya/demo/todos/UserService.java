package com.surya.demo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // user creation
    public int createUser(Map<String, String> userData){
        User newUser = new User();
        newUser.setName(userData.get("name"));
        newUser.setMail(userData.get("mail"));
        User newSavedUser = userRepository.save(newUser);
        return newSavedUser.getId();
    }

    //update user

    // delete user

    //getUserById
}
