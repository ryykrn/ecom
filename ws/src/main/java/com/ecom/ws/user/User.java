package com.ecom.ws.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="\"user\"")
public class User {

    @Getter
    @Setter
    @GeneratedValue
    @Id
    long id;

    @Getter
    @Setter
    String username;

    @Getter
    @Setter
    String password;

    @Getter
    @Setter
    String email;
}
