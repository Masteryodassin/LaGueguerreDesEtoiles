package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class explorationController {

    @RequestMapping(value = "/universe/planet/exploration", method = RequestMethod.POST)
    public String checkDistance (Model model){
        return "exploration";
    }


    @RequestMapping(value = "/universe/planet/exploration/scout", method = RequestMethod.GET)
    public String sendScout (Model model) {
        return "exploration";
    }

}
