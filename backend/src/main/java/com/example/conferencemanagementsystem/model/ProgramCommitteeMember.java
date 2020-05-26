package com.example.conferencemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProgramCommitteeMember {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User user;
    private String name;
    private String affiliation;
    private String email;
    private String webPage;
    private boolean isCoChair;
    private boolean hasRegistered;

    public boolean isCoChair() {
        return isCoChair;
    }

    public void setCoChair(boolean coChair) {
        isCoChair = coChair;
    }

    public boolean isHasRegistered() {
        return hasRegistered;
    }

    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
}
