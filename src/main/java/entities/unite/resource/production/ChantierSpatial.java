package entities.unite.resource.production;

import entities.unite.Unite;
import entities.utils.Constantes;
import entities.utils.Couts;

public class ChantierSpatial extends Unite {

    public ChantierSpatial () {
        super();
        
        this.setCountFer(Couts.FERCHANTIERSPATIAL);
        this.setCountOr(Couts.ORCHANTIERSPATIAL);
        this.getCountPlutonium(Couts.PLUTONIUMCHANTIERSPATIAL);
        this.setHitPoint(Constantes.HPCHANTIERSPATIAL);
    }

}
