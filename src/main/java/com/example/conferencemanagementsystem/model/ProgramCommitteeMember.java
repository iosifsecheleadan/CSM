package com.example.conferencemanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProgramCommitteeMember {
    @Id
    private int id;
    private String name;
    private String affiliation;
    private String email;
    private String username;
    private String password;
    private String webPage;

    public ProgramCommitteeMember(int id, String name, String affiliation, String email, String username, String password, String webPage) {
        this.id = id;
        this.name = name;
        this.affiliation = affiliation;
        this.email = email;
        this.username = username;
        this.password = password;
        this.webPage = webPage;
    }

    public ProgramCommitteeMember() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
}
