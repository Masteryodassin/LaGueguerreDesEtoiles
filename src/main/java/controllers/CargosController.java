package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CargosController {

    @RequestMapping(value = "/universe/planet/exploration/cargos", method = RequestMethod.POST)
    public String checkDestination(Model model){
        return "exploration";
    }

    @RequestMapping(value = "/universe/planet/exploration/cargos", method = RequestMethod.GET)
    public String sendCargos(Model model){
        return "exploration";

    }
}
