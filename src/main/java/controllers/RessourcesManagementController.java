package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RessourcesManagementController {

    @RequestMapping(value = "/universe/planet", method = RequestMethod.POST)
    public String checkRessources (Model model){
        return "planet";
}
}