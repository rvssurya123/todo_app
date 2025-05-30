package com.surya.demo.todos;

import com.surya.demo.dtos.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // user creation
    public int createUser(UserRequestDto userData){
        User newUser = new User();
        newUser.setName(userData.getName());
        newUser.setMail(userData.getMail());
        User newSavedUser = userRepository.save(newUser);
        return newSavedUser.getId();
    }

    //update user

    // delete user

    //getUserById
}
