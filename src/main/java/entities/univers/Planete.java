package entities.univers;


import entities.unite.Unite;
import entities.unite.orbitale.UniteOrbitale;
import entities.unite.resource.Hangar;
import entities.unite.resource.production.ChantierSpatial;
import entities.unite.resource.production.UsineArmement;

import java.util.ArrayList;
import java.util.List;


public class Planete {


    private int id;
    private int playerId;
    private int planetSize;
    private int coordx;
    private int coordy;
    private int fer;
    private int or;
    private int plutonium;
    private boolean occupied;
    private boolean champForce;
    List<Unite> unites;
    List<UniteOrbitale> unitesOrbitales;

    //constructeur

    public Planete(){

    }

    // vérifie qu'il reste de l'espace disponible sur la planète

    public boolean hasRoom(){

        if (unites.size() >= planetSize){
            return false;
        }
        return true;
    }

    // vérifie qu'il y a assez d'or en stock sur la planète

    public boolean enoughGold(Unite unite){
        boolean b;
        if (unite.getCountOr() > currentGoldStock()){
            b = false;
        }
        else{
            b =true;
        }
        return b;
    }

    // vérifie qu'il y a assez de fer en stock sur la planète

    public boolean enoughIron(Unite unite){
        boolean b;
        if (unite.getCountFer() > currentIronStock()){
            b = false;
        }
        else{
            b =true;
        }
        return b;
    }

    // vérifie qu'il y a assez de plutonium en stock sur la planète

    public boolean enoughPlutonium(Unite unite){
        boolean b;
        if (unite.getCountPlutonium() > currentPlutoniumStock()){
            b = false;
        }
        else{
            b =true;
        }
        return b;
    }

    // vérifie qu'il y a au moins un chantier spatial sur la planète

    public boolean hasChantierSpatial(boolean b){
        b = false;
        for (Unite unite : unites
             ) {
            if (unite.getClass() == ChantierSpatial.class){
                b = true;
            }

        }
        return b;
    }

    // vérifie qu'il y a au moins une usine d'armement sur la planète

    public boolean hasUsineArmement(boolean b){
        b = false;
        for (Unite unite : unites
                ) {
            if (unite.getClass() == UsineArmement.class){
                b = true;
            }

        }
        return b;
    }

    //calcule les stocks d'or cumulés sur l'ensemble des hangars de la planète

    private Integer currentGoldStock(){
        int a = 0;
        List<Hangar> hangars = new ArrayList<>();
        for (Unite unite: unites
                ) {
            if (unite.getClass() == Hangar.class){
                hangars.add((Hangar)unite);
            }
        }
        for (int i = 0 ; i < hangars.size(); i++){
            a = a + hangars.get(i).getStockOr();
        }
        return a;
    }

    //calcule les stocks de fer cumulés sur l'ensemble des hangars de la planète

    private Integer currentIronStock(){
        int a = 0;
        List<Hangar> hangars = new ArrayList<>();
        for (Unite unite: unites
                ) {
            if (unite.getClass() == Hangar.class){
                hangars.add((Hangar)unite);
            }
        }
        for (int i = 0 ; i < hangars.size(); i++){
            a = a + hangars.get(i).getStockFer();
        }
        return a;
    }

    //calcule les stocks de plutonium cumulés sur l'ensemble des hangars de la planète

    private Integer currentPlutoniumStock(){
        int a = 0;
        List<Hangar> hangars = new ArrayList<>();
        for (Unite unite: unites
                ) {
            if (unite.getClass() == Hangar.class){
                hangars.add((Hangar)unite);
            }
        }
        for (int i = 0 ; i < hangars.size(); i++){
            a = a + hangars.get(i).getStockPlutonium();
        }
        return a;
    }


    ///////////////////////////// getters and setters ///////////////////////////////

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
        return occupied;
    }

    public void setOccuped(boolean occupied) {
        this.occupied = occupied;
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

    public int getPlanetSize() {
        return planetSize;
    }

    public void setPlanetSize(int planetSize) {
        this.planetSize = planetSize;
    }

}
