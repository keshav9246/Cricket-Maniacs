package com.cricket.wc2019.Controllers;

import com.cricket.wc2019.Models.Scores;
import com.cricket.wc2019.Services.ManiacService;
import com.cricket.wc2019.Services.PlayerService;
import com.cricket.wc2019.Services.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ScoresController {

    @Autowired
    ScoresService service;

    @Autowired
    PlayerService pService;

    @Autowired
    ManiacService mService;

    @Autowired
    Scores score;


    @PostMapping("/scoreUpdate")
    public ModelAndView updateScores(@RequestParam("runs") int runs, @RequestParam("balls") int balls, @RequestParam("isNotOut") boolean isNotOut, @RequestParam("wickets") int wickets, @RequestParam("economy") float economy, @RequestParam("catches") int catches,
                                     @RequestParam("playerrole") String role, @RequestParam("directhits") int directHits, @RequestParam("playername") String playername, @RequestParam("captain") boolean isCaptain)
    {
        int totalMatchScore = 0;


        System.out.println (playername);


                score= service.updateScores(runs, balls, isNotOut, wickets, economy, catches, role, directHits,playername, isCaptain);


                pService.addPlayerScore(score.getTotal_match_score(), playername);


        ModelAndView mv = new ModelAndView("admin", "scores", score);

            return mv;




    }

    @GetMapping("/scores")
    public ModelAndView getScores()
    {
        List<Scores> scoreList = service.getAllScores();

        ModelAndView mv = new ModelAndView("scores", "scoreList", scoreList);
        return mv;
    }

}
