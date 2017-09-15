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

    private Hangar hangar;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PlanetManagementService planetManagementService;

    private Planete planete;
    private int planetId;
    private Joueur joueur;
    private String message;
    private UniteTypeList uniteTypeList;
    List<Unite> unites;

    @RequestMapping(value = "universe/planetManagement", method = RequestMethod.GET)
    public String getUnite(Model model, HttpSession session) {

        this.planetId = (int) session.getAttribute("planetId");
        this.joueur = (Joueur) session.getAttribute("joueur");
        uniteTypeList = new UniteTypeList();

        this.planete = planetService.getById(planetId, joueur);
        this.unites = planete.getUnites();
        this.message = "bienvenue sur la planete" + String.valueOf(planetId);

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

            if (!planete.enoughIron(unite)) {

                message = message + "& pas assez de fer";
            }
            if (!planete.enoughGold(unite)) {

                message = message + "& pas assez d'or";
            }
            if (!planete.enoughPlutonium(unite)) {

                message = message + "& pas assez de fer";
            } else {

                this.joueur.getPlanetes().remove(planete);
                this.planete = planetManagementService.createUnite(unite, planete);
                this.joueur.getPlanetes().add(planete);

                message = unite.getClass().getSimpleName() + " batie avec succes";
            }
        } else {
            message = "vous devez d'abord construire un hangar pour produire des unités";
        }

        session.removeAttribute("joueur");
        session.setAttribute("joueur", joueur);
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

        planete = planetService.getById(planetId, joueur);

        if (planetManagementService.deleteUnite(unite, planete)) {

            message = "Unite detruite avec succes";
        }

        message = "l'unite choisie ne peut être détruite";
        return "planetManagement";
    }
}
