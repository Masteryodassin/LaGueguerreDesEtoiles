package controllers;

import entities.univers.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class startController {

    @Autowired
    private StartSevice startSevice;

    @RequestMapping(value= "/start", method = RequestMethod.GET)
    public String form (Model model){
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String startGame (@RequestParam(value= "joueur") Joueur joueur, Model model){
        model.addAttribute("joueur", joueur);
        return "universe";
    }


    }


