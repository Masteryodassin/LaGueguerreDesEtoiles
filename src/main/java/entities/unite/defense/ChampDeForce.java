package entities.unite.defense;

import entities.unite.Unite;
import entities.utils.Constantes;
import entities.utils.Couts;

public class ChampDeForce extends Unite {

    public ChampDeForce () {
        super();

        this.setCountFer(Couts.FERCHAMPFORCE);
        this.setCountOr(Couts.ORCHAMPFORCE);
        this.setCountPlutonium(Couts.PLUTONIUMCHAMPFORCE);
        this.setHitPoint(Constantes.HPCHAMPFORCE);
    }

}
