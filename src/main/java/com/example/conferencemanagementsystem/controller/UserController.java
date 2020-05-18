package com.example.conferencemanagementsystem.controller;

import com.example.conferencemanagementsystem.model.User;
import com.example.conferencemanagementsystem.model.dto.UserDto;
import com.example.conferencemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<String> getHello() {
        return new ResponseEntity<>("HELLO WORLD",HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        boolean couldAdd = userService.addUser(new User(userDto));
        System.out.println(couldAdd);
        if (!couldAdd) {
            return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
