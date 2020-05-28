package com.example.conferencemanagementsystem.service;

import com.example.conferencemanagementsystem.exception.MyException;
import com.example.conferencemanagementsystem.model.Conference;
import com.example.conferencemanagementsystem.model.ProgramCommitteeMember;
import com.example.conferencemanagementsystem.model.User;
import com.example.conferencemanagementsystem.model.validator.ConferenceValidator;
import com.example.conferencemanagementsystem.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProgramCommitteeMemberService programCommitteeMemberService;

    @Autowired
    ConferenceValidator conferenceValidator;

    public List<Conference> getConferences() {
        return conferenceRepository.findAll();
    }

    public void addConference(Conference conference) throws MyException {
        conferenceValidator.validate(conference, userService);
        List<ProgramCommitteeMember> PCMembers=conference.getProgramCommittee();
        for (ProgramCommitteeMember member: PCMembers) {
            member.setUser(userService.getUser(member.getUser().getUsername()));
            programCommitteeMemberService.addPCMember(member);
        }
        conference.setProgramCommittee(PCMembers);
        List<User> SCMembers = conference.getSteeringCommittee();
        for (int i=0; i<SCMembers.size();i++) {
            SCMembers.set(i, userService.getUser(SCMembers.get(i).getUsername()));
        }
        conference.setSteeringCommittee(SCMembers);
        conferenceRepository.save(conference);
    }

    public void registerPcMember(ProgramCommitteeMember programCommitteeMember, int id) throws MyException {
        programCommitteeMemberService.updatePCMember(programCommitteeMember, id);
    }
}
