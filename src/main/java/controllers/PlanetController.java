package controllers;

import entities.univers.Joueur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanetController {

    @RequestMapping(value = "universe/planet/{id}", method = RequestMethod.GET)
    public String choosePlanet (@PathVariable(value = "JoueurId") int JoueurId){
        return "planet";
    }



}
