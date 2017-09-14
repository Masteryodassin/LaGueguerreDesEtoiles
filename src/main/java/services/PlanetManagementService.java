package services;

import entities.univers.Planete;
import org.springframework.stereotype.Service;

@Service
public class PlanetManagementService {

    private Planete planete;



    public boolean canBuid (){
    return true;
    }

}
