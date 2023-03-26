package com.cricket.wc2019.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.wc2019.Models.DailyScores;
import com.cricket.wc2019.Models.Users;
import com.cricket.wc2019.Repositories.DailyScoresRepository;


@Service
public class DailyScoreService {
	
	@Autowired
	private DailyScoresRepository repo;
	
	@Autowired
	private DailyScores ds;
	
	public void addDailyScore(int score, String playerName)
	{
		//DailyScores ds = new DailyScores();
		ds.setPlayer_name(playerName);
		ds.setScore(score);
		repo.save(ds);

	}
	
	public List<Integer> getOnlyScores(String players)
	{
		 List<Integer> scores = new ArrayList<>();
	        
		scores = repo.getTeamScores(players);
		return scores;
	}

}
