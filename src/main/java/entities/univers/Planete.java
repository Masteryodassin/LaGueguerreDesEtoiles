package entities.univers;


import entities.unite.Unite;
import entities.unite.orbitale.UniteOrbitale;

import java.util.List;


public class Planete {

    private int id;
    private int playerId;
    private int coordx;
    private int coordy;
    private int fer;
    private int or;
    private int plutonium;
    private boolean occuped;
    private boolean champForce;
    List<Unite> unites;
    List<UniteOrbitale> unitesOrbitales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getCoordx() {
        return coordx;
    }

    public void setCoordx(int coordx) {
        this.coordx = coordx;
    }

    public int getCoordy() {
        return coordy;
    }

    public void setCoordy(int coordy) {
        this.coordy = coordy;
    }

    public int getFer() {
        return fer;
    }

    public void setFer(int fer) {
        this.fer = fer;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public int getPlutonium() {
        return plutonium;
    }

    public void setPlutonium(int plutonium) {
        this.plutonium = plutonium;
    }

    public boolean isOccuped() {
        return occuped;
    }

    public void setOccuped(boolean occuped) {
        this.occuped = occuped;
    }

    public boolean isChampForce() {
        return champForce;
    }

    public void setChampForce(boolean champForce) {
        this.champForce = champForce;
    }

    public List<Unite> getUnites() {
        return unites;
    }

    public void setUnites(List<Unite> unites) {
        this.unites = unites;
    }

    public List<UniteOrbitale> getUnitesOrbitales() {
        return unitesOrbitales;
    }

    public void setUnitesOrbitales(List<UniteOrbitale> unitesOrbitales) {
        this.unitesOrbitales = unitesOrbitales;
    }

}
