package controllers;


import com.sun.org.apache.xpath.internal.operations.Mod;
import entities.Mock.PlanetMock;
import entities.unite.Unite;
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
import java.util.List;


@Controller
public class PlanetManagementController {

    private PlanetManagementService planetManagementService;

    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = "/universe/planet/planetManagement", method = RequestMethod.GET)
    public String getUnite (Model model, HttpSession session){
        int planetId = (int) session.getAttribute("planetId");
        Joueur joueur = (Joueur) session.getAttribute("joueur");

        Planete planete = planetService.getById(planetId, joueur);
        model.addAttribute("planete", planete);
        List<Unite> unites = planete.getUnites();

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
