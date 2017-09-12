package controllers;

import entities.univers.Planete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class startController {

    @RequestMapping(value= "/form", method = RequestMethod.GET)
    public String form (Model model){

    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String startGame (@RequestParam(value= "userName", required = false) String userName, Model model){
        model.addAttribute("userName", userName);
        return "start";
    }

 //   @RequestMapping(value = "/start", method = RequestMethod.POST)
 //   public String startGame (@RequestParam(value= "listPlanet")List<Planete> listPlanet, Model model){
   //  model.addAttribute("listPlanet", listPlanet);
   //    return "start";
    }


