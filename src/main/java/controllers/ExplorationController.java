package controllers;

import entities.univers.Planete;
import entities.univers.Univers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.ExplorationService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ExplorationController {

    @Autowired
    private ExplorationService explorationService;

    @RequestMapping(value = "/universe/planet/exploration", method = RequestMethod.GET)
    public String checkDistance (Model model, HttpSession session){

        List<Planete> planeteList = explorationService.getNotOwnedPlanetes(
                (Univers) session.getAttribute("univers"),
                (int) session.getAttribute("playerId")
        );

        model.addAttribute("planetes", planeteList);
        return "exploration";
    }


    @RequestMapping(value = "/universe/planet/exploration/scout", method = RequestMethod.GET)
    public String sendScout (Model model) {
        return "exploration";
    }

}
