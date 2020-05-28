package com.example.conferencemanagementsystem.controller;

import com.example.conferencemanagementsystem.exception.MyException;
import com.example.conferencemanagementsystem.model.Conference;
import com.example.conferencemanagementsystem.model.Message;
import com.example.conferencemanagementsystem.model.ProgramCommitteeMember;
import com.example.conferencemanagementsystem.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    ResponseEntity<List<Conference>> getConferences() {
        System.out.println("GETTING CONFERENCES");
        return new ResponseEntity<>(conferenceService.getConferences(), HttpStatus.OK);
    }

    @RequestMapping(value = "/conferences/register/{id}", method = RequestMethod.POST)
    ResponseEntity<Message> registerPcMember(@PathVariable int id, @RequestBody ProgramCommitteeMember programCommitteeMember) {
        try {
            conferenceService.registerPcMember(programCommitteeMember, id);
            return new ResponseEntity<>(new Message("okay"), HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(new Message(e.getMessage()),HttpStatus.OK);
        }
    }
}
