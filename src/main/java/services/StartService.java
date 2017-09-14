package services;


import entities.Mock.PlanetMock;
import entities.univers.Joueur;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartService {

    private PlanetMock planetMock = new PlanetMock();
    private List<Planete> planetes = new ArrayList<>();


    public Univers createUniverse(){

        this.planetes.add(planetMock.planete1);
        this.planetes.add(planetMock.planete2);
        Univers univers = new Univers(planetes);
        return univers;
    }

    public Joueur createPlayer(String userName){

        Joueur joueur = new Joueur(1);
        joueur.setId(1);
        joueur.setUsername(userName);

        for (Planete planete : planetes) {
            if (planete.getPlayerId() != joueur.getId()){
                planetes.remove(planete);
            }
        }

        joueur.setPlanetes(planetes);
        return joueur;
    }
}

