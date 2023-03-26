package com.cricket.wc2019.Services;

import com.cricket.wc2019.Models.Scores;
import com.cricket.wc2019.Repositories.ScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresService {

    public int id = 101;

    @Autowired
    private Scores individualScore;

    @Autowired
    private ScoresRepository repo;

    public Scores updateScores(int runs, int balls, boolean isNotOut, int wickets, float economy, int catches, String role, int directHits, String playerName, boolean isCaptain) {
        // System.out.println("----------------------ROLROLEROLE--------------------------------------- "+role);
        int batting_bonus = 0;
        int bowling_bonus = 0;
        int totalBattingPoints = 0;
        int wicketPoints = 0;
        int catchPoints = 0;
        int directHitPoints = 0;
        float strikeRate = 0;
        int totalBowlingPoints = 0;
        int totalFieldingPoints = 0;
        int totalMatchScore = 0;
        String wk = "Wicketkeeper";


        if (balls != 0) {
            strikeRate = (runs * 100) / balls;
        }


        //System.out.println("----------------------ROLROLEROLE--------------------------------------- "+role+"="+wk);
        individualScore.setScore_id(++id);
        individualScore.setPlayer_name(playerName);
        individualScore.setRuns(runs);
        individualScore.setBalls(balls);
        individualScore.setStrike_rate(strikeRate);
        individualScore.setIs_notout(isNotOut);


        // -15 if batsman get out on 0
        if (runs == 0 && isNotOut == false) {
            batting_bonus -= 15;
        }


        // +25 for not outs
        if (isNotOut == true && balls > 24) {
            batting_bonus += 25;
        }

        // +5 for 50 each and +25 for SR > 125
        if (runs >= 50 && runs < 100) {
            batting_bonus += 5;
        } else if (runs >= 100 && runs < 150) {
            batting_bonus += 12;
        } else if (runs >= 150 && runs < 200) {
            batting_bonus += 20;
        } else if (runs >= 200 && runs < 250) {
            batting_bonus += 30;
        } else if (runs >= 250) {
            batting_bonus += 50;
        }

        if (strikeRate >= 125 && runs >= 45) {
            batting_bonus += 15;
        }

        if (strikeRate >= 150 && runs >= 50) {
            batting_bonus += 10;
        }
        if (strikeRate >= 175 && runs >= 70) {
            batting_bonus += 10;
        }

        totalBattingPoints = runs + batting_bonus;

        individualScore.setBatting_points(totalBattingPoints);

        //bowling
        individualScore.setWickets(wickets);
        individualScore.setEconomy(economy);

        if (economy == 0) {
            bowling_bonus += 0;
        } else if (economy <= 4.0) {
            bowling_bonus += 20;
        } else if (economy > 9.0) {
            bowling_bonus -= 25;
        } else if (economy > 8.0) {
            bowling_bonus -= 15;
        } else if (economy > 7.0) {
            bowling_bonus -= 10;
        }

        if (wickets > 0) {
            wicketPoints += wickets * 25;
        }
        if(wickets >= 5)
        {
        	bowling_bonus += 25;
        }


        totalBowlingPoints = wicketPoints + bowling_bonus;
        individualScore.setBowling_points(totalBowlingPoints);
        individualScore.setCatches(catches);
        individualScore.setDirect_hit(directHits);

        System.out.print(role);
        if (role.trim().equalsIgnoreCase(wk)) {
            catchPoints = catches * 7;
        } else {
            catchPoints = catches * 10;
        }

        directHitPoints = directHits * 25;

        totalFieldingPoints = catchPoints + directHitPoints;
        individualScore.setFielding_points(totalFieldingPoints);

        totalMatchScore = totalBattingPoints + totalBowlingPoints + totalFieldingPoints;

        if (isCaptain == true) {
            System.out.println("inside gvhgvhgv");
            totalMatchScore *= 1.5;
        }

        individualScore.setTotal_match_score(totalMatchScore);


        repo.save(individualScore);



        return individualScore;

    }


    public List<Scores> getAllScores() {
        List<Scores> score_list = (List<Scores>) repo.findAll();
        return score_list;
    }

}
