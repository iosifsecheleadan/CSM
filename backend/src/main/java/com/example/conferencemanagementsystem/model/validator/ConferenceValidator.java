package com.example.conferencemanagementsystem.model.validator;

import com.example.conferencemanagementsystem.exception.MyException;
import com.example.conferencemanagementsystem.model.Conference;
import com.example.conferencemanagementsystem.model.ProgramCommitteeMember;
import com.example.conferencemanagementsystem.model.User;
import com.example.conferencemanagementsystem.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ConferenceValidator {
    public void validate(Conference conference, UserService userService) throws MyException {
        String errorMessage="";
        String name=conference.getName();
        if (name.length()==0) {
            errorMessage+="The conference name cannot be empty. <br>";
        }
        String callForPapers=conference.getCallForPapers();
        if (callForPapers.length()<10) {
            errorMessage+="The call for papers must be at least 10 characters long. <br>";
        }
        if (callForPapers.length()>250) {
            errorMessage+="The call for papers must be at most 250 characters long. <br>";
        }
        Date firstDay=conference.getFirstDay();
        Date lastDay=conference.getLastDay();
        Date abstractDeadline=conference.getAbstractDeadline();
        Date fullPaperDeadline=conference.getFullPaperDeadline();
        Date biddingDeadline=conference.getBiddingDeadline();
        Date reviewingDeadline=conference.getReviewingDeadline();
        if (firstDay == null || lastDay == null || abstractDeadline == null || fullPaperDeadline == null || biddingDeadline == null || reviewingDeadline == null) {
            errorMessage+="All dates must be specified. <br>";
            throw new MyException(errorMessage);
        }
        if (lastDay.before(firstDay)) {
            errorMessage+="The last day of the conference cannot be before the first day. <br>";
        }
        if(fullPaperDeadline.before(abstractDeadline)) {
            errorMessage+="The deadline for the full paper cannot be before the deadline for the abstract paper. <br>";
        }
        if(!biddingDeadline.after(abstractDeadline)) {
            errorMessage+="The bidding deadline must be after the abstract paper submission deadline. <br>";
        }
        if(!reviewingDeadline.after(biddingDeadline)) {
            errorMessage+="The reviewing deadline must be after the bidding deadline. <br>";
        }
        if(!reviewingDeadline.after(fullPaperDeadline)) {
            errorMessage+="The reviewing deadline must be after the full paper submission deadline. <br>";
        }
        if(!reviewingDeadline.before(firstDay)) {
            errorMessage+="The reviewing deadline must be before the first day of the conference. <br>";
        }
        int participationFee=conference.getParticipationFee();
        System.out.println("fee "+participationFee);
        if(participationFee<0) {
            errorMessage+="The participation fee must be non-negative. <br>";
        }
        List<ProgramCommitteeMember> programCommitteeMemberList=conference.getProgramCommittee();
        for (ProgramCommitteeMember member: programCommitteeMemberList) {
            if(!userService.userExists(member.getUser())) {
                errorMessage+="User "+member.getUser().getUsername()+" does not exist. <br>";
            }
        }
        if (programCommitteeMemberList.size()<5) {
            errorMessage+="There must be at least 5 Program Committee members. <br>";
        }
        List<User> steeringCommittee=conference.getSteeringCommittee();
        for (User user: steeringCommittee) {
            if (!userService.userExists(user)) {
                errorMessage+="User "+user.getUsername()+" does not exist. <br>";
            }
        }
        if (errorMessage.length()>0) {
            throw new MyException(errorMessage);
        }
    }
}
