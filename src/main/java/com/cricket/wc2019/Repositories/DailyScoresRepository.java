package com.cricket.wc2019.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cricket.wc2019.Models.DailyScores;

@Repository
public interface DailyScoresRepository extends CrudRepository<DailyScores, Integer> {

@Query(value = "Select score from DailyScores where player_name = ?1")	
public List<Integer> getTeamScores(String player);

}
