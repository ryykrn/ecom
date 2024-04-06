package com.ecom.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ws.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
