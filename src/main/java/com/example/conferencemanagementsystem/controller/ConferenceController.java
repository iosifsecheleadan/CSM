package com.example.conferencemanagementsystem.controller;

import com.example.conferencemanagementsystem.exception.MyException;
import com.example.conferencemanagementsystem.model.Conference;
import com.example.conferencemanagementsystem.model.Message;
import com.example.conferencemanagementsystem.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConferenceController {
    @Autowired
    ConferenceService conferenceService;

    @RequestMapping(value = "/conferences", method = RequestMethod.POST)
    ResponseEntity<Message> saveUser(@RequestBody Conference conference) {
        try {
            conferenceService.addConference(conference);
            return new ResponseEntity<>(new Message("okay"),HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(new Message(e.getMessage()),HttpStatus.OK);
        }
    }
}