package entities.univers;


import entities.unite.Unite;
import entities.unite.orbitale.UniteOrbitale;

import java.util.List;

@Getter
public class Planete {

    private int id;
    private int coordx;
    private int coordy;
    private int fer;
    private int or;
    private int plutonium;
    private boolean occuped;
    private boolean champForce;
    List<Unite> unites;
    List<UniteOrbitale> unitesOrbitales;

}
