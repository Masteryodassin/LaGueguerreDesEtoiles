package entities.unite.resource;

import entities.unite.Unite;

public class Hangar extends Unite {

    private int stockOr;
    private int stockFer;
    private int stockPlutonium;


    public Hangar(){
        this.setStockFer(0);
        this.setStockOr(0);
        this.setStockPlutonium(0);
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
