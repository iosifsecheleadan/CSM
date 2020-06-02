package com.example.conferencemanagementsystem.controller;

import com.example.conferencemanagementsystem.model.Message;
import com.example.conferencemanagementsystem.model.Section;
import com.example.conferencemanagementsystem.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SectionController {
    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/sections", method = RequestMethod.POST)
    ResponseEntity<Message> saveSection(@RequestBody Section section) {
        this.sectionService.addSection(section);
        return new ResponseEntity<>(new Message("okay"), HttpStatus.OK);
    }
}
