package services;

import entities.univers.Joueur;
import entities.univers.Planete;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {

    private Planete planete;


    public List<Planete> getByPlayerId(int id, Joueur joueur){
        List<Planete> planetes = new ArrayList<>();


        for (Planete planete: joueur.getPlanetes()
             ) {
            if (planete.getPlayerId() == id){
                planetes.add(planete);
            }
        }
        return planetes;
    }

    public Planete getById(int id, Joueur joueur) {

        Planete pr = null;
    for (Planete p : joueur.getPlanetes()) {
        if (p.getPlayerId() == id) {
            pr = p;
        }
    }
        /*planete = joueur.getPlanetes().stream().
                filter(p -> planete.getPlayerId() == id).findAny().get();*/

        return pr;
    }


}
