package com.ecom.ws.error;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    
    private String path;
    private String message;
    private int status;
    private Date timestamp = new Date();
    private Map<String, String> validationErrors = new HashMap<>();
}
