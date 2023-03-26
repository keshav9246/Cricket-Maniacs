package com.cricket.wc2019.Services;

import com.cricket.wc2019.Models.Maniac;
import com.cricket.wc2019.Models.Player;
import com.cricket.wc2019.Repositories.ManiacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class ManiacService {

    @Autowired
    ManiacRepository repo;

    @Autowired
    Maniac team;

    @Autowired
    List<Maniac> friends;
    
    public void submitTeam(List<Player> players, String orange, String purple, String maniac)
    {
        team.setManiac_name(maniac);
        team.setOrange_cap(orange);
        team.setPurple_cap(purple);
        team.setTeam(players);


        repo.save(team);


    }
    
    public List<Maniac> getAllManiacs()
    {
    	
       friends = (List<Maniac>) repo.findAll();
       
      
       return friends;
    }
    
    

    public Maniac getManiacTeam( String ManiacName)
    {
        return repo.findById(ManiacName).orElse(null);
    }
    

    public Maniac getManiacScore( String ManiacName)
    {
        team = repo.findById(ManiacName).orElse(null);
        return team;
    }


    //update total score for maniac


}
