package services;

import entities.Mock.PlanetMock;
import entities.unite.Unite;
import entities.univers.Planete;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetManagementService {

    private Planete planete;
    private Unite unite;
    private PlanetMock planeteMock = new PlanetMock();


    public List<Unite> getUniteByPlanet(int joueurId){
        planete = planeteMock.planete1;
        List<Unite> unites = planete.getUnites();

        return unites;
    }

}
