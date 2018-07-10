package com.library.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{

    @GetMapping("/user/IsAvailable/{input}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable("input") String input)
    {
        System.out.println("Data Service Request - isAvailable - " + input);
        Boolean result = input.contains("User1");
        System.out.println("Data Service Response - isAvailable - " + result);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

}
