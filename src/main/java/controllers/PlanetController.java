package controllers;


import entities.univers.Planete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.PlanetService;

import java.util.List;

@Controller
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = "universe/planet/{id}", method = RequestMethod.GET)
    public String getPlanetList (Model model, @PathVariable(value = "id") int JoueurId){

        List<Planete> planetes = planetService.getByPlayerId(JoueurId);
        model.addAttribute("planeteList",planetes);

        return "planet";
    }

}
