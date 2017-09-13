package entities.Mock;

import entities.univers.Joueur;
import entities.univers.Planete;

import java.util.ArrayList;
import java.util.List;

public class JoueurMock {

    public  Joueur joueur = new Joueur();

    private PlanetMock planetMock = new PlanetMock();
    private List<Planete> planeteList = new ArrayList<>();

    public JoueurMock(){
        planeteList.add(planetMock.planete1);

        joueur.setId(1);
        joueur.setUsername("Toto");
        joueur.setPlanetes(planeteList);
    }
}
