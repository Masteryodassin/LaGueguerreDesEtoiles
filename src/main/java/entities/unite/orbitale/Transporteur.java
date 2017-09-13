package entities.unite.orbitale;

import entities.utils.Constantes;
import entities.utils.Couts;

public class Transporteur extends UniteOrbitale{

    public Transporteur(int x , int y){
        super();

        this.setCoordX(x);
        this.setCoordY(y);

        this.setCountFer(Couts.FERTRANSPORTEUR);
        this.setCountOr(Couts.ORTRANSPORTEUR);
        this.setCountPlutonium(Couts.PLUTONIUMTRANSPORTEUR);
        this.setHitPoint(Constantes.HPTRANSPORTEUR);
        this.setVitesse(Constantes.VITESSETRANSPORTEUR);
        this.setTempProduction(Constantes.TEMPPROD);
    }
}
