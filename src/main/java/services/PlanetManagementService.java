package services;


import entities.unite.resource.Hangar;
import entities.unite.resource.recolte.MineFer;
import entities.unite.resource.recolte.MineOr;
import entities.unite.resource.recolte.UsinePlutonium;
import entities.univers.Planete;
import org.springframework.stereotype.Service;

import entities.unite.Unite;
import services.resourcesThread.ExtractResourcesThread;

import java.util.List;


@Service
public class PlanetManagementService <T extends Unite>{

    private  ExtractResourcesThread extractResourcesThread;

    private List <Unite> unites;


    public int getAvailableSpace(Planete planete){

        unites = planete.getUnites();
        int space = planete.getPlanetSize()-unites.size();

        return space;
    }

    public boolean createUnite(T unite, Planete planete){

        Hangar hangar = (Hangar) planete.getUnites().stream()
                .filter(c -> Unite.class.equals(Hangar.class))
                .findFirst()
                .get();

       if (planete.hasRoom() && planete.enoughGold(unite)
               && planete.enoughIron(unite)
               && planete.enoughPlutonium(unite)){
           planete.getUnites().add(unite);



           if (unite.getClass().equals(MineFer.class)
                   && unite.getClass().equals(MineOr.class)
                   && unite.getClass().equals(UsinePlutonium.class)){

               extractResourcesThread = new ExtractResourcesThread(unite,planete,hangar);
               extractResourcesThread.run();

           }
           return true;

       }
           return false;
    }

    public boolean deleteUnite(T unite, Planete planete){

        if (planete.getUnites().contains(unite)){
            planete.getUnites().remove(unite);

            return true;
        }

        return false;
    }



}
