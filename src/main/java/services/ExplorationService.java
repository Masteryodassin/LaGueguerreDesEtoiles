package services;


import entities.unite.orbitale.Chasseur;
import entities.unite.orbitale.Croiseur;
import entities.unite.orbitale.Scout;
import entities.unite.orbitale.UniteOrbitale;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExplorationService {

    private String redirect;


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

    public String travelling (UniteOrbitale uniteOrbitale, Planete departure, Planete destination){
        long travelDistance = Math.abs(destination.getCoordx() - departure.getCoordx())
                + Math.abs(destination.getCoordy() - destination.getCoordy());

        long travelTime = travelDistance / Long.valueOf(uniteOrbitale.getVitesse());

        if (uniteOrbitale.getClass() == Scout.class){
            redirect = "redirect: /scout";
        }

        else if (uniteOrbitale.getClass() == Croiseur.class || uniteOrbitale.getClass() == Chasseur.class){
            redirect = "redirect: /fight";
        }
        else {
            redirect ="redirect: /cargos";
        }

        return redirect;
    }
}
