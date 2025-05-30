package com.surya.demo.todos;

import com.surya.demo.dtos.UserRequestDto;
import com.surya.demo.dtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // add user
    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto user){
        int id = userService.createUser(user);
        System.out.println(id);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(id);

//        Map<String, Integer> response = new HashMap<>();
//        response.put("id", id);
        return userResponseDto;
    }
}
