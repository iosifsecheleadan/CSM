package com.example.conferencemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Conference conference;
    @OneToOne
    private ProgramCommitteeMember mainChair;
    private String room;
    private int noSeats;
    private int listenerFee;
}
