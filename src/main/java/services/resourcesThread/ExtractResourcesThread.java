package services.resourcesThread;

import entities.unite.Unite;
import entities.unite.resource.Hangar;
import entities.unite.resource.recolte.MineFer;
import entities.unite.resource.recolte.MineOr;
import entities.unite.resource.recolte.UsinePlutonium;
import entities.univers.Planete;
import entities.utils.Constantes;
import org.springframework.stereotype.Service;


public class ExtractResourcesThread <T extends Unite> implements Runnable{

    private T mineType;
    private Planete planete;
    private Hangar hangar;

    private Boolean isFer = false;
    private Boolean isOr = false;
    private Boolean isPlutonium = false;


    @Override
    public void run() {

        System.out.println("Start extracting with " + mineType.getClass().toString());

        while(isFer && planete.getFer() > 0 && hangar.getStockFer() < Constantes.STOCKAGEFER){
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ie){
                System.out.println("unexpected interruption exception");
            }
            for (Unite unite: planete.getUnites()
                 ) {
                if (!unite.getClass().equals(MineFer.class)){
                    isFer=false;
                }
            }


            int resourceLeftOver = planete.getFer() - Constantes.RATIOEXTRACTIONFER;
            int resourceExtracted = hangar.getStockFer() + Constantes.RATIOEXTRACTIONFER;

            planete.setFer(resourceLeftOver);
            hangar.setStockFer(resourceExtracted);
        }

        while(isOr && planete.getOr() > 0 && hangar.getStockOr() < Constantes.STOCKAGEOR){
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ie){
                System.out.println("unexpected interruption exception");
            }

            System.out.println("extraction de " + String.valueOf(Constantes.RATIOEXTRACTIONFER) + "fer");

            for (Unite unite: planete.getUnites()
                    ) {
                if (!unite.getClass().equals(MineOr.class)){
                    isOr=false;
                }
            }

            System.out.println("extraction de " + String.valueOf(Constantes.RATIOEXTRACTIONOR) + "Or");

            int resourceLeftOver = planete.getOr() - Constantes.RATIOEXTRACTIONOR;
            int resourceExtracted = hangar.getStockOr() + Constantes.RATIOEXTRACTIONOR;

            planete.setOr(resourceLeftOver);
            hangar.setStockOr(resourceExtracted);
        }

        while(isPlutonium && planete.getPlutonium() > 0 && hangar.getStockPlutonium() < Constantes.STOCKAGEPLUTONIUM){
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ie){
                System.out.println("unexpected interruption exception");
            }

            System.out.println("extraction de " + String.valueOf(Constantes.RATIOEXTRACTIONPLUTONIUM) + "Plutonium");

            for (Unite unite: planete.getUnites()
                    ) {
                if (!unite.getClass().equals(UsinePlutonium.class)){
                    isPlutonium=false;
                }
            }

            int resourceLeftOver = planete.getPlutonium() - Constantes.RATIOEXTRACTIONPLUTONIUM;
            int resourceExtracted = hangar.getStockPlutonium() + Constantes.RATIOEXTRACTIONPLUTONIUM;

            planete.setPlutonium(resourceLeftOver);
            hangar.setStockPlutonium(resourceExtracted);
        }

    }

    public ExtractResourcesThread (T item, Planete planete, Hangar hangar) {
        checkResourceType(item);
        this.mineType = item;
        this.planete = planete;
        this.hangar = hangar;

    }

    public void checkResourceType (T item){

        if (item.getClass().equals(MineFer.class)){
            isFer = true;
        }
        else if (item.getClass().equals(MineOr.class)){
            isOr = true;
        }
        else if (item.getClass().equals(UsinePlutonium.class)){
            isPlutonium = true;
        }

    }

    ///////////////////// Getters and Setters ////////////////////////

    public T getMineType() {
        return mineType;
    }

    public Boolean getFer() {
        return isFer;
    }

    public Boolean getOr() {
        return isOr;
    }

    public Boolean getPlutonium() {
        return isPlutonium;
    }

}
