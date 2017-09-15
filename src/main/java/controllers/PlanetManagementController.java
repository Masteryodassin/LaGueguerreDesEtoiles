package controllers;


import entities.unite.Unite;
import entities.unite.resource.Hangar;
import entities.univers.Joueur;
import entities.univers.Planete;
import entities.utils.UniteTypeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.PlanetManagementService;
import services.PlanetService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class PlanetManagementController {


    @Autowired
    private PlanetService planetService;

    @Autowired
    private PlanetManagementService planetManagementService;

    private Planete planete;
    private Hangar hangar;
    private int planetId;
    private Joueur joueur;
    private String message;
    private UniteTypeList uniteTypeList;
    List<Unite> unites;
    int fer = 0;
    int Or = 0;
    int plutonium = 0;
    int dispo = 0;

    @RequestMapping(value = "universe/planetManagement", method = RequestMethod.GET)
    public String getUnite(Model model, HttpSession session) {

        this.planetId = (int) session.getAttribute("planetId");
        this.joueur = (Joueur) session.getAttribute("joueur");
        uniteTypeList = new UniteTypeList();

        this.planete = planetService.getById(planetId, joueur);
        this.unites = planete.getUnites();
        this.message = "bienvenue sur la planete" + String.valueOf(planetId);

        this.dispo = planetManagementService.getAvailableSpace(planete);

        for (Unite united : planete.getUnites()
                ) {
            if (united instanceof Hangar){
                hangar = (Hangar) united;

               this.Or = hangar.getStockOr();
               this.fer = hangar.getStockFer();
               this.plutonium = hangar.getStockPlutonium();
            }

        }

        model.addAttribute("dispo", dispo);
        model.addAttribute("Or", Or);
        model.addAttribute("Fer", fer);
        model.addAttribute("Plutonium", plutonium);
        model.addAttribute("uniteTypes", uniteTypeList.unites);
        model.addAttribute("uniteOrbitaleTypes", uniteTypeList.uniteOrbitales);
        model.addAttribute("planete", planete);
        model.addAttribute("unites", unites);
        model.addAttribute("message", message);

        return "planetManagement";
    }


    @RequestMapping(value = "universe/planetManagement", method = RequestMethod.POST)
    public String buildUnit(Model model, HttpSession session, @RequestParam("UniteType") String typeName) {

        planetId = (int) session.getAttribute("planetId");
        joueur = (Joueur) session.getAttribute("joueur");

        Unite unite = planetManagementService.getUniteFromName(typeName);

        boolean b = false;

        for (Unite united : planete.getUnites()
             ) {
            if (united instanceof Hangar){
                b = true;
            }

        }
        if (b) {

            if (!planete.hasRoom()) {
                message = "plus de place disponible";
            }

            else if (!planete.enoughIron(unite)) {

                message = message + "& pas assez de fer";
            }
            else if (!planete.enoughGold(unite)) {

                message = message + "& pas assez d'or";
            }
            else if (!planete.enoughPlutonium(unite)) {

                message = message + "& pas assez de fer";
            } else {

                this.joueur.getPlanetes().remove(planete);
                this.planete = planetManagementService.createUnite(unite, planete);
                this.joueur.getPlanetes().add(planete);

                for (Unite united : planete.getUnites()
                        ) {
                    if (united instanceof Hangar){
                        hangar = (Hangar) united;

                        this.Or = hangar.getStockOr();
                        this.fer = hangar.getStockFer();
                        this.plutonium = hangar.getStockPlutonium();
                    }


                }

                message = unite.getClass().getSimpleName() + " batie avec succes";
            }
        } else {
            message = "vous devez d'abord construire un hangar pour produire des unités";
        }

        this.dispo = planetManagementService.getAvailableSpace(planete);


        session.setAttribute("joueur", joueur);
        model.addAttribute("dispo", dispo);
        model.addAttribute("Or", Or);
        model.addAttribute("Fer", fer);
        model.addAttribute("Plutonium", plutonium);
        model.addAttribute("uniteTypes", uniteTypeList.unites);
        model.addAttribute("uniteOrbitaleTypes", uniteTypeList.uniteOrbitales);
        model.addAttribute("planete", planete);
        model.addAttribute("unites", unites);
        model.addAttribute("message", message);
        return "planetManagement";
    }


    @RequestMapping(value = "universe/planeteManagement", method = RequestMethod.DELETE)
    public String deleteUnit(Model model, HttpSession session, @RequestParam("uniteType") Unite unite) {

        planetId = (int) session.getAttribute("planetId");
        joueur = (Joueur) session.getAttribute("joueur");

        this.planete = planetService.getById(planetId, joueur);

        this.joueur.getPlanetes().remove(planete);

        if (!planete.getUnites().isEmpty()) {

            message = "Unite detruite avec succes";
            planete.setUnites(planetManagementService.deleteUnite(unite, planete));
            this.joueur.getPlanetes().add(planete);
        }

        message = "l'unite choisie ne peut être détruite";


        session.setAttribute("joueur", joueur);
        model.addAttribute("dispo", dispo);
        model.addAttribute("Or", Or);
        model.addAttribute("Fer", fer);
        model.addAttribute("Plutonium", plutonium);
        model.addAttribute("uniteTypes", uniteTypeList.unites);
        model.addAttribute("uniteOrbitaleTypes", uniteTypeList.uniteOrbitales);
        model.addAttribute("planete", planete);
        model.addAttribute("unites", unites);
        model.addAttribute("message", message);

        return "planetManagement";
    }
}
