package entities.unite.resource.recolte;

import entities.unite.Unite;
import entities.utils.Constantes;
import entities.utils.Couts;

public class MineFer extends Unite {
    public MineFer(){

        this.setCountFer(Couts.FERMINEFER);
        this.setCountOr(Couts.ORMINEFER);
        this.setCountPlutonium(Couts.PLUTONIUMMINEFER);
        this.setHitPoint(Constantes.HPMINEFER);
    }
}
