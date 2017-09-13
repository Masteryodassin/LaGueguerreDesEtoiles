package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.PlanetService;

@Controller
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = "universe/planet/{id}", method = RequestMethod.GET)
    public String choosePlanet (Model model, @PathVariable(value = "id") int JoueurId){



        return "planet";
    }

}
