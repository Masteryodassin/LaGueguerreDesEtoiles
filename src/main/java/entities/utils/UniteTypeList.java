package entities.utils;

import entities.unite.Unite;
import entities.unite.defense.ChampDeForce;
import entities.unite.defense.Tourelle;
import entities.unite.orbitale.*;
import entities.unite.resource.Hangar;
import entities.unite.resource.production.ChantierSpatial;
import entities.unite.resource.recolte.MineFer;
import entities.unite.resource.recolte.MineOr;
import entities.unite.resource.recolte.UsinePlutonium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UniteTypeList {

    public List<Unite> unites = new ArrayList<>();
    public List<UniteOrbitale> uniteOrbitales = new ArrayList<>();
    public Map<String,Unite> uniteFromName = new HashMap<>();


    public UniteTypeList(){

        unites.add(new Hangar());
        unites.add(new MineOr());
        unites.add(new MineFer());
        unites.add(new UsinePlutonium());
        unites.add(new ChampDeForce());
        unites.add(new ChantierSpatial());
        unites.add(new Tourelle());

        uniteOrbitales.add(new Chasseur());
        uniteOrbitales.add(new Croiseur());
        uniteOrbitales.add(new Scout());
        uniteOrbitales.add(new Transporteur());

        for (Unite unite : unites
             ) {
            uniteFromName.put(unite.getClass().getSimpleName().toString(),unite);

        }
        for (Unite unite : uniteOrbitales
                ) {
            uniteFromName.put(unite.getClass().getSimpleName().toString(),unite);

        }
    }

}
