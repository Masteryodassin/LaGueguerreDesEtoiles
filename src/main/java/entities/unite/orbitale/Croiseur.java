package entities.unite.orbitale;

import entities.unite.defense.IUniteAttaquante;
import entities.utils.Constantes;
import entities.utils.Couts;

public class Croiseur extends UniteOrbitale implements IUniteAttaquante{

    private int attaque;

    public Croiseur (){
        super();

/*
        this.setCoordX(x);
        this.setCoordY(y);
*/

        this.setCountFer(Couts.FERCROISEUR);
        this.setCountOr(Couts.ORCROISEUR);
        this.setCountPlutonium(Couts.PLUTONIUMCROISEUR);
        this.setHitPoint(Constantes.HPCROISEUR);
        this.setVitesse(Constantes.VITESSECROISEUR);
        this.setAttaque(Constantes.ATTAQUECROISEUR);
        this.setTempProduction(Constantes.TEMPPROD);
    }


    @Override
    public void setAttaque(int a) {
        this.attaque = a;
    }

    public int getAttaque() {
        return attaque;
    }
}
