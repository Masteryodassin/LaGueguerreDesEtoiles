package services;

import entities.Mock.PlanetMock;
import entities.unite.Unite;
import entities.unite.resource.Hangar;
import entities.univers.Planete;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlanetManagementService <T extends Unite>{

    private Planete planete;
    private Unite unite;


    public int getAvailableSpace(){
        List<Unite> unites = planete.getUnites();
        int space = planete.getPlanetSize()-unites.size();
        return space;
    }

    public boolean createUnite(T unite){
       return true;
    }

    public Unite deleteUnite(){
        return null;
    }



}
