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
import java.util.List;


public class UniteTypeList {

    public static List<Unite> unites = new ArrayList<>();
    public static List<UniteOrbitale> uniteOrbitales = new ArrayList<>();
    Unite unite;

    public UniteTypeList(){

        unites.add(new Hangar());
        unites.add(new MineOr());
        unites.add(new MineFer());
        unites.add(new UsinePlutonium());
        unites.add(new ChampDeForce());
        unites.add(new ChantierSpatial());
        unites.add(new Tourelle());
        unites.add(new Hangar());
        unites.add(new Hangar());

        uniteOrbitales.add(new Chasseur());
        uniteOrbitales.add(new Croiseur());
        uniteOrbitales.add(new Scout());
        uniteOrbitales.add(new Transporteur());
    }

}
