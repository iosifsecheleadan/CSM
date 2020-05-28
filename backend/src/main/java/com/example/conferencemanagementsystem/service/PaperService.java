package com.example.conferencemanagementsystem.service;

import com.example.conferencemanagementsystem.model.Paper;
import com.example.conferencemanagementsystem.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    @Autowired
    PaperRepository paperRepository;

    public void addPaper(Paper paper) {
        paperRepository.save(paper);
    }
}
