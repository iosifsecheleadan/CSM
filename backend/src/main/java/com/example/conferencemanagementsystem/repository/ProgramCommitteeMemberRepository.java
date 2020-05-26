package com.example.conferencemanagementsystem.repository;

import com.example.conferencemanagementsystem.model.ProgramCommitteeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProgramCommitteeMemberRepository extends JpaRepository<ProgramCommitteeMember, Integer> {

    @Query(value = "SELECT * FROM program_committee_member WHERE user_username = :username", nativeQuery = true)
    Optional<ProgramCommitteeMember> findByUsername(@Param("username") String username);
}
