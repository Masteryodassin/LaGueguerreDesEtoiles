package entities.mock;

import entities.univers.Planete;
import entities.univers.Univers;

import java.util.ArrayList;
import java.util.List;

public class UniversMock {

   public Univers univers = new Univers();
   private PlanetMock planetMock = new PlanetMock();
   private List<Planete> planeteList = new ArrayList<>();

    public UniversMock(){
        planeteList.add(planetMock.planete1);
        planeteList.add(planetMock.planete2);

        univers.setPlanetes(planeteList);
    }
}
