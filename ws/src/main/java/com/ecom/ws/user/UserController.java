package com.ecom.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ws.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecom.ws.shared.GenericMessage;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/v1/users")
    public String getUsers(@RequestParam(required=false) String param) {
        return new String("hello users");
    }

    @PostMapping("/api/v1/users")
    public GenericMessage postUser(@RequestBody User user) {
        userService.save(user);
        return new GenericMessage("User created");
    }
    
    
}