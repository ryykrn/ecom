package com.ecom.ws;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ws.user.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
