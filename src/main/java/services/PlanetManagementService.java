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



    public boolean canBuid (){
    return true;
    }

}
