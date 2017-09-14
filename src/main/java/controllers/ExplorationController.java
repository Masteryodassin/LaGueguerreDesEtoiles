package controllers;

import entities.unite.orbitale.UniteOrbitale;
import entities.univers.Joueur;
import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.ExplorationService;
import services.PlanetService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ExplorationController {

    @Autowired
    private ExplorationService explorationService;

    @Autowired
    private PlanetService planetService;


    @RequestMapping(value = "/universe/planet/exploration", method = RequestMethod.GET)
    public String checkDistance (Model model, HttpSession session){

        List<Planete> planeteList = explorationService.getNotOwnedPlanetes(
                (Univers) session.getAttribute("univers"),
                (int) session.getAttribute("playerId")
        );

        Planete planete = planetService
                .getById((int) session.getAttribute("planetId"), (Joueur) session.getAttribute("joueur"));

        List <UniteOrbitale> UniteOrbitales = planete.getUnitesOrbitales();

        model.addAttribute("planetes", planeteList);
        model.addAttribute("uniteOrbitales", UniteOrbitales);

        return "exploration";
    }


    @RequestMapping(value = "/universe/planet/exploration", method = RequestMethod.POST)
    public String sendScout (Model model, HttpSession session,
                             @RequestParam("unite") UniteOrbitale uniteOrbitale,
                             @RequestParam("chosenPlanet") Planete chosenPlanet) {

        Planete planete = planetService
                .getById((int) session.getAttribute("planetId"), (Joueur) session.getAttribute("joueur"));

        explorationService.travelling(uniteOrbitale, chosenPlanet, planete);

        return "exploration";
    }

}
