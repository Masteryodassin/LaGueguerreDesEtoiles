package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class planetManagementController {


    @RequestMapping(value = "/universe/planet", method = RequestMethod.GET)
    public String canBuildUnit (Model model){
        return "planet";
    }

    @RequestMapping(value = "/universe/planet/construction", method = RequestMethod.POST)
    public String buildUnit(Model model){
        return "planet";
    }

    @RequestMapping(value = "/universe/planet", method = RequestMethod.DELETE)
    public String deleteUnit(Model model){
        return "planet";
    }

}
