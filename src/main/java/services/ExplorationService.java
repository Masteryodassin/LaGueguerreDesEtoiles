package services;


import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExplorationService {

    public List<Planete> getNotOwnedPlanetes(Univers univers,int id){

        List<Planete> planetes = univers.getPlanetes();
        List<Planete> notOwnedPlanetes = new ArrayList<>();

        for (Planete planete : planetes
                ) {
            if (planete.getPlayerId() != id){
                notOwnedPlanetes.add(planete);
            }
        }
        return planetes;
    }
}
