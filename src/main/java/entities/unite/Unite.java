package entities.unite;

public abstract class Unite {

    private int id;
    private int hitPoint;
    private int countOr;
    private int countFer;
    private int countPlutonium;
    private long tempProduction;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getCountOr() {
        return countOr;
    }

    public void setCountOr(int countOr) {
        this.countOr = countOr;
    }

    public int getCountFer() {
        return countFer;
    }

    public void setCountFer(int countFer) {
        this.countFer = countFer;
    }

    public int getCountPlutonium() {
        return countPlutonium;
    }

    public void setCountPlutonium(int countPlutonium) {
        this.countPlutonium = countPlutonium;
    }

    public long getTempProduction() {
        return tempProduction;
    }

    public void setTempProduction(long tempProduction) {
        this.tempProduction = tempProduction;
    }
}
