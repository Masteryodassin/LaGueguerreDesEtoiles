package controllers;

import entities.univers.Planete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.PlanetService;
import services.RessourcesManagementService;

import javax.servlet.http.HttpSession;


@Controller
public class RessourcesManagementController {

    @Autowired
    RessourcesManagementService ressourcesManagementService;

    @Autowired
    PlanetService planetService;

    private Planete planete;

    @RequestMapping(value = "/universe/planet/resources", method = RequestMethod.GET)
    public String checkRessources (Model model, HttpSession session){
       int planeteId = (int) session.getAttribute("planeteId");

        return "planetManagement";
    }
}
