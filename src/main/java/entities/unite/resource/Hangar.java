package entities.unite.resource;

import entities.unite.Unite;
import entities.utils.Constantes;

public class Hangar extends Unite {

    private int stockOr;
    private int stockFer;
    private int stockPlutonium;


    public Hangar(){
        this.setStockFer(50);
        this.setStockOr(25);
        this.setStockPlutonium(10);
    }

    ////////////////////////// Getters and Setters ///////////////////////////

    public int getStockOr() {
        return stockOr;
    }

    public void setStockOr(int stockOr) {
        this.stockOr = stockOr;
    }

    public int getStockFer() {
        return stockFer;
    }

    public void setStockFer(int stockFer) {
        this.stockFer = stockFer;
    }

    public int getStockPlutonium() {
        return stockPlutonium;
    }

    public void setStockPlutonium(int stockPlutonium) {
        this.stockPlutonium = stockPlutonium;
    }

}
