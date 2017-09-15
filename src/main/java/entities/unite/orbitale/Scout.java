package entities.unite.orbitale;

import entities.utils.Constantes;
import entities.utils.Couts;

public class Scout extends UniteOrbitale{
    
    public Scout(int x , int y){
        super();
        
        this.setCoordX(x);
        this.setCoordY(y);

        this.setCountFer(Couts.FERSCOUT);
        this.setCountOr(Couts.ORSCOUT);
        this.setCountPlutonium(Couts.PLUTONIUMSCOUT);
        this.setHitPoint(Constantes.HPSCOUT);
        this.setVitesse(Constantes.VITESSESCOUT);
        this.setTempProduction(Constantes.TEMPPROD);
    }
    public Scout(){}
}
