package com.ecom.ws.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ws.error.ApiError;
import com.ecom.ws.shared.GenericMessage;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/api/v1/users")
    public String getUsers(@RequestParam(required = false) String param) {
        return new String("hello users");
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<?> postUser(@RequestBody User user, HttpServletRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        var apiError = new ApiError();
        apiError.setPath(request.getRequestURL().toString());
        apiError.setMessage("Validation Error");
        apiError.setStatus(400);
        apiError.setValidationErrors(validationErrors);

        if (user.getUsername() == null || user.getUsername().isEmpty() ) {
            validationErrors.put("username", "username can not be null");
            return ResponseEntity.badRequest().body(apiError);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return ResponseEntity.ok().body(new GenericMessage("User created"));
    }

}