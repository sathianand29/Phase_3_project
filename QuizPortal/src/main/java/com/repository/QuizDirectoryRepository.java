package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.QuizDirectory;


@Repository
public interface QuizDirectoryRepository extends JpaRepository<QuizDirectory, Integer> {

}