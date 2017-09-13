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

    PlanetMock planetMock = new PlanetMock();

    
    public Univers createUniverse(){
        List<Planete> planetes = new ArrayList<>();
        planetes.add(planetMock.planete1);
        planetes.add(planetMock.planete2);
        Univers univers = new Univers(planetes);
        return univers;

    }

    public Joueur createPlayer(String userName){
        Joueur joueur = new Joueur(1);
        joueur.setUsername(userName);
        return joueur;
    }


    }

