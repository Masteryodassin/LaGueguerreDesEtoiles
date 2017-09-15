package entities.unite.orbitale;

import entities.unite.defense.IUniteAttaquante;
import entities.utils.Constantes;
import entities.utils.Couts;
import sun.awt.geom.AreaOp;

public class Chasseur extends UniteOrbitale implements IUniteAttaquante{

    private int attaque;

    public Chasseur(int x , int y){
        super();

        this.setCoordX(x);
        this.setCoordY(y);

        this.setCountFer(Couts.FERCHASSEUR);
        this.setCountOr(Couts.ORCHASSEUR);
        this.setCountPlutonium(Couts.PLUTONIUMCHASSEUR);
        this.setHitPoint(Constantes.HPCHASSEUR);
        this.setVitesse(Constantes.VITESSECHASSEUR);
        this.setAttaque(Constantes.ATTAQUECHASSEUR);
        this.setTempProduction(Constantes.TEMPPROD);

    }

    public Chasseur(){}

    @Override
    public void setAttaque(int a ) {
        this.attaque = a;
    }

    public int getAttaque() {
        return attaque;
    }
}
