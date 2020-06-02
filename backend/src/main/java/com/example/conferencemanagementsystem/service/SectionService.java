package com.example.conferencemanagementsystem.service;

import com.example.conferencemanagementsystem.model.Section;
import com.example.conferencemanagementsystem.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;

    public void addSection(Section section) {
        this.sectionRepository.save(section);
    }
}
