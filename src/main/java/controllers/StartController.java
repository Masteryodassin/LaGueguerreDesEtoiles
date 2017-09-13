package controllers;

import entities.univers.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.StartService;

import javax.servlet.http.HttpSession;


@Controller
public class StartController {

    @Autowired
    private StartService startSevice;

    private Joueur joueur;

    @RequestMapping(value= "/start", method = RequestMethod.GET)
    public String form (Model model){
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String startGame (@RequestParam(value= "userName") String userName, Model model, HttpSession session){
        model.addAttribute("joueur", joueur);
        joueur = startSevice.createPlayer(userName);
         session.setAttribute("id", joueur.getId());
        return "universe";
    }


    }


