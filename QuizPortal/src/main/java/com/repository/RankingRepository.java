package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Ranking;


@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {

}