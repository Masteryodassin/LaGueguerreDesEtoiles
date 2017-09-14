package entities.mock;

import entities.unite.Unite;
import entities.unite.defense.ChampDeForce;
import entities.unite.defense.Tourelle;
import entities.unite.resource.Hangar;
import entities.univers.Planete;

import java.util.ArrayList;
import java.util.List;

public class PlanetMock {

    public Planete planete1 = new Planete();
    public Planete planete2 = new Planete();
    private List<Unite> unites = new ArrayList<>();

    //génération de deux planètes types
    
    public PlanetMock(){
        
        unites.add(new Hangar());

        planete1.setId(1);
        planete1.setPlayerId(1);
        planete1.setChampForce(false);
        planete1.setCoordx(2);
        planete1.setCoordx(4);
        planete1.setFer(100);
        planete1.setOr(100);
        planete1.setPlutonium(100);
        planete1.setPlanetSize(50);
        planete1.setOccuped(true);
        planete1.setUnites(unites);

        unites.add(new Tourelle());
        unites.add(new ChampDeForce());

        planete2.setId(2);
        planete2.setPlayerId(2);
        planete2.setChampForce(true);
        planete2.setCoordx(2);
        planete2.setCoordx(4);
        planete2.setFer(100);
        planete2.setOr(100);
        planete2.setPlutonium(100);
        planete2.setPlanetSize(75);
        planete2.setOccuped(true);
        planete2.setUnites(unites);

    }

}
