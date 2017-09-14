package controllers;


import com.sun.org.apache.xpath.internal.operations.Mod;
import entities.Mock.PlanetMock;
import entities.unite.Unite;
import entities.unite.orbitale.UniteOrbitale;
import entities.unite.resource.Hangar;
import entities.univers.Joueur;
import entities.univers.Planete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/universe/planet/planetManagement", method = RequestMethod.GET)
    public String getUnite (Model model, HttpSession session){
        int planetId = (int) session.getAttribute("planetId");
        Joueur joueur = (Joueur) session.getAttribute("joueur");

        Planete planete = planetService.getById(planetId, joueur);
        model.addAttribute("planete", planete);

        List<Unite> unites = planete.getUnites();
        model.addAttribute("unites", unites);

       // Map<String, Integer> ressources = planetManagementService.getRessources();
       // model.addAttribute("ressources", ressources);

        return "planetManagement";

    }


  //  @RequestMapping(value = "/universe/planet/planetManagement", method = RequestMethod.GET)
   // public String canBuildUnit (Model model){
   //     return "planetManagement";
  //  }

    @RequestMapping(value = "/universe/planet/construction", method = RequestMethod.POST)
    public String buildUnit(Model model){
        return "planetManagement";
    }


    @RequestMapping(value = "/universe/planet", method = RequestMethod.DELETE)
    public String deleteUnit(Model model){
        return "planetManagement";
    }

}
