package controllers;


import entities.unite.Unite;
import entities.unite.orbitale.UniteOrbitale;
import entities.unite.resource.Hangar;
import entities.univers.Joueur;
import entities.univers.Planete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.PlanetManagementService;
import services.PlanetService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @RequestMapping(value = "/universe/planet/planetManagement", method = RequestMethod.GET)
    public String getUnite (Model model, HttpSession session){

        planetId = (int) session.getAttribute("planetId");
        joueur = (Joueur) session.getAttribute("joueur");

        planete = planetService.getById(planetId, joueur);
        model.addAttribute("planete", planete);

        List<Unite> unites = planete.getUnites();
        model.addAttribute("unites", unites);

        return "planetManagement";

    }


    @RequestMapping(value = "/universe/planet/construction", method = RequestMethod.POST)
    public String buildUnit(Model model, HttpSession session, @RequestParam ("typeUnite") Unite unite){

        Hangar hangar = new Hangar();

        planetId = (int) session.getAttribute("planetId");
        joueur = (Joueur) session.getAttribute("joueur");

        planete = planetService.getById(planetId, joueur);

        if (planete.getUnites().contains(hangar)) {

            if (planetManagementService.createUnite(unite, planete)) {

                message = unite.getClass().getSimpleName() + "batie avec succes";
            }
            else {
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
                }
            }

            message = "vous devez construire un hangar";

        }
        model.addAttribute("message", message);
        return "planetManagement";
    }


    @RequestMapping(value = "/universe/planet/destruction", method = RequestMethod.DELETE)
    public String deleteUnit(Model model, HttpSession session, @RequestParam ("unite") Unite unite){

        planetId = (int) session.getAttribute("planetId");
        joueur = (Joueur) session.getAttribute("joueur");

        planete = planetService.getById(planetId, joueur);

       if ( planetManagementService.deleteUnite(unite, planete)){

           message = "Unite detruite avec succes";
       }

       message = "l'unite choisie ne peut être détruite";
        return "planetManagement";
    }



}
