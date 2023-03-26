package com.cricket.wc2019.Models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Component
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "score_id", updatable = false, nullable = false)
    private Integer score_id;




    private String player_name;
    private int runs;
    private int balls;
    private float strike_rate;
    private boolean is_notout;
    private int batting_points;
    private int wickets;
    private float economy;
    private int bowling_points;
    private int direct_hit;
    private int catches;
    private int fielding_points;
    private int total_match_score;

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public boolean isIs_notout() {
        return is_notout;
    }

    public void setIs_notout(boolean is_notout) {
        this.is_notout = is_notout;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public float getStrike_rate() {
        return strike_rate;
    }

    public void setStrike_rate(float strike_rate) {
        this.strike_rate = strike_rate;
    }

    public int getBatting_points() {
        return batting_points;
    }

    public void setBatting_points(int batting_points) {
        this.batting_points = batting_points;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getEconomy() {
        return economy;
    }

    public void setEconomy(float economy) {
        this.economy = economy;
    }

    public int getBowling_points() {
        return bowling_points;
    }

    public void setBowling_points(int bowling_points) {
        this.bowling_points = bowling_points;
    }

    public int getDirect_hit() {
        return direct_hit;
    }

    public void setDirect_hit(int direct_hit) {
        this.direct_hit = direct_hit;
    }

    public int getCatches() {
        return catches;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public int getFielding_points() {
        return fielding_points;
    }

    public void setFielding_points(int fielding_points) {
        this.fielding_points = fielding_points;
    }

    public int getTotal_match_score() {
        return total_match_score;
    }

    public void setTotal_match_score(int total_match_score) {
        this.total_match_score = total_match_score;
    }
}
