package com.cricket.wc2019.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
public class DailyScores {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scoreid", updatable = false, nullable = false)
	private int scoreid;
	private String player_name;
	private int score;
	
	
	 public int getScore_id() {
		return scoreid;
	}
	public void setScore_id(int score_id) {
		this.scoreid = score_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


}