package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Participant;


@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}