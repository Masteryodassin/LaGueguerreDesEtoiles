package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccueilController {

    @RequestMapping("/")
    public String welcome (Model model){
        return "accueil";
    }
}
