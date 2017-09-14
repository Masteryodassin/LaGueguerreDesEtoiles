package controllers;


import entities.univers.Joueur;
import entities.univers.Planete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.PlanetService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = "universe/planet", method = RequestMethod.GET)
    public String getPlanetList ( Model model, HttpSession session){
       int joueurId = (int) session.getAttribute("id");
        List<Planete> planetes = planetService.getByPlayerId(joueurId, (Joueur) session.getAttribute("joueur"));
        model.addAttribute("planeteList",planetes);

        return "planet";
    }

}
