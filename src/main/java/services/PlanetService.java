package services;

import entities.Mock.PlanetMock;
import entities.Mock.UniversMock;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    private Planete planete;
    @Autowired
    private Univers univers;

    private UniversMock universMock = new UniversMock();


    public Planete getByPlayerId(int id){
        univers = universMock.univers;

        return null;
    }
}
