package services;


import entities.unite.resource.Hangar;
import entities.unite.resource.recolte.MineFer;
import entities.unite.resource.recolte.MineOr;
import entities.unite.resource.recolte.UsinePlutonium;
import entities.univers.Planete;
import entities.utils.UniteTypeList;
import org.springframework.stereotype.Service;

import entities.unite.Unite;
import services.resourcesThread.ExtractResourcesThread;

import java.util.List;


@Service
public class PlanetManagementService<T extends Unite> {

    private Hangar hangar;

    private ExtractResourcesThread extractResourcesThread;

    private List<Unite> unites;

    private UniteTypeList uniteTypeList;


    public int getAvailableSpace(Planete planete) {

        unites = planete.getUnites();
        int space = planete.getPlanetSize() - unites.size();

        return space;
    }

    public Planete createUnite(T unite, Planete planete) {


        for (Unite united : planete.getUnites()
                ) {
            if (unite instanceof Hangar) {
                hangar = (Hangar) unite;
            }
        }

        if (planete.hasRoom() && planete.enoughGold(unite)
                && planete.enoughIron(unite)
                && planete.enoughPlutonium(unite)) {
            planete.getUnites().add(unite);

            // change les stocks de resources dans le hangar

            hangar = getFullHangar(planete);

            planete.getUnites().remove(hangar);

            hangar.setStockFer(hangar.getStockFer() - unite.getCountFer());
            hangar.setStockOr(hangar.getStockOr() - unite.getCountOr());
            hangar.setStockFer(hangar.getStockPlutonium() - unite.getCountPlutonium());

            planete.getUnites().add(hangar);

            //lance le thread d'extraction

            if (unite.getClass().equals(MineFer.class)
                    && unite.getClass().equals(MineOr.class)
                    && unite.getClass().equals(UsinePlutonium.class)) {

                extractResourcesThread = new ExtractResourcesThread(unite, planete, hangar);
                extractResourcesThread.run();
            }
        }
        return planete;
    }

    public Unite getUniteFromName(String name) {

        uniteTypeList = new UniteTypeList();
        Unite unite = uniteTypeList.uniteFromName.get(name);

        return unite;
    }

    public boolean deleteUnite(T unite, Planete planete) {

        if (planete.getUnites().contains(unite)) {
            planete.getUnites().remove(unite);

            return true;
        }

        return false;
    }

    public Hangar getFullHangar(Planete planete) {

        for (Unite united : planete.getUnites()
                ) {
            if (united instanceof Hangar) {
                hangar = (Hangar) united;

                if (hangar.getStockOr() > 0 && hangar.getStockFer() > 0 && hangar.getStockPlutonium() > 0){
                    return hangar;
                }

            }

        }
        return null;
    }


}
