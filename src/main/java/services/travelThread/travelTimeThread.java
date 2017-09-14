package services.travelThread;

import entities.unite.orbitale.Chasseur;
import entities.unite.orbitale.Croiseur;
import entities.unite.orbitale.Scout;
import entities.unite.orbitale.UniteOrbitale;

public class travelTimeThread <T extends UniteOrbitale> implements Runnable{

     private T uniteType;
     private long travelTime;

    @Override
    public void run() {
        try {
            Thread.sleep(travelTime);
        }catch (InterruptedException ie){
            System.out.println("unexpected interruption exception");
        }

        if (this.uniteType.getClass() == Scout.class){

        }

        if (this.uniteType.getClass() == Croiseur.class || this.uniteType.getClass() == Chasseur.class){

        }

    }

    public travelTimeThread (T item, long time){
        this.uniteType = item;
        this.travelTime = time * 1000;
    }
}
