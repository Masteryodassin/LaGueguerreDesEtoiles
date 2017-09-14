package services;


import entities.univers.Planete;
import org.springframework.stereotype.Service;

import entities.unite.Unite;
import java.util.List;


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
