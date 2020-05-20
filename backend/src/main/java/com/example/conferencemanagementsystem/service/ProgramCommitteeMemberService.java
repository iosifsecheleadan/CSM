package com.example.conferencemanagementsystem.service;

import com.example.conferencemanagementsystem.model.ProgramCommitteeMember;
import com.example.conferencemanagementsystem.repository.ProgramCommitteeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramCommitteeMemberService {
    @Autowired
    ProgramCommitteeMemberRepository programCommitteeMemberRepository;

    public void addPCMember(ProgramCommitteeMember member) {
        programCommitteeMemberRepository.save(member);
    }
}
