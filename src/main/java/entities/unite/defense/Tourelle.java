package entities.unite.defense;

import entities.unite.Unite;
import entities.utils.Constantes;
import entities.utils.Couts;


public class Tourelle extends Unite implements IUniteAttaquante{

    private int attaque;

    public Tourelle (){
        super();

        this.setCountFer(Couts.FERTOURELLE);
        this.setCountOr(Couts.ORTOURELLE);
        this.setCountPlutonium(Couts.PLUTONIUMTOURELLE);
        this.setHitPoint(Constantes.HPTOURELLE);
        this.setAttaque(Constantes.ATTAQUETOURELLE);
    }

    public int getAttaque() {
        return attaque;
    }

    @Override
    public void setAttaque(int a) {
        this.attaque = a;
    }

}
