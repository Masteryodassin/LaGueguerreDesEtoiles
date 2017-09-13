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

    public PlanetMock planetMock;

    public Univers createUniverse(){
        List<Planete> planetes = new ArrayList<>();
        Univers univers = new Univers(planetes);
        planetes.add(planetMock.planete1);
        planetes.add(planetMock.planete2);
        return univers;
    }

    public Joueur createPlayer(String userName){
        Joueur joueur = new Joueur(1);
        joueur.setUsername(userName);
        return joueur;
    }


}

