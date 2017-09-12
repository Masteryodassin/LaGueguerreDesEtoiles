package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class fightManagementController {

    @RequestMapping(value = "/universe/planet/exploration/fight", method = RequestMethod.GET)
    public String fight(Model model){
        return "exploration";
    }
}
