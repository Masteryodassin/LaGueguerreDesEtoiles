package services;

import entities.Mock.PlanetMock;
import entities.Mock.UniversMock;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {


    private Univers univers;
    private Planete planete;
    private UniversMock universMock = new UniversMock();


    public List<Planete> getByPlayerId(int id){
        univers = universMock.univers;
        List<Planete> planetes = new ArrayList<>();


        for (Planete planete: univers.getPlanetes()
             ) {
            if (planete.getPlayerId() == id){
                planetes.add(planete);
            }
        }
        return planetes;
    }
}
