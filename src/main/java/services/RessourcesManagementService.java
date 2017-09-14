package services;

import entities.unite.resource.Hangar;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RessourcesManagementService {

    private Hangar hangar;


    public Map<String, Integer> getRessources(){
        Map<String, Integer> ressources = new HashMap<>();
        ressources.put("fer", hangar.getStockFer());
        ressources.put("or", hangar.getStockOr());
        ressources.put("plutonium", hangar.getStockPlutonium());

        return ressources;

    }


}
