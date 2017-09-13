package entities.unite.resource.production;

import entities.unite.Unite;
import entities.utils.Constantes;
import entities.utils.Couts;

public class UsineArmement extends Unite {

    public UsineArmement() {
        super();

        this.setCountFer(Couts.FERUSINEARMEMENT);
        this.setCountOr(Couts.ORUSINEARMEMENT);
        this.setCountPlutonium(Couts.PLUTONIUMUSINEARMEMENT);
        this.setHitPoint(Constantes.HPUSINEARMEMENT);
    }
}
