package services;


import entities.Mock.PlanetMock;
import entities.univers.Joueur;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class startService {



    public Univers startGame(){
        createUniverse();
        createPlayer();

        return null;
    }

    public Univers createUniverse(List<Planete> planetes){
        Univers univers = new Univers(planetes);
        planetes.add(PlanetMock.planet1());
        planetes.add(PlanetMock.planet2());
        return univers;

    }

    public Joueur createPlayer(int id){
        Joueur joueur = PlanetMock.joueur1();
        return joueur;
    }


    }

