package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.core.response.bet.ShowAllBetsResponse;
import lv.javaguru.java2.hardcore.core.services.bet.ShowAllBetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showAllBetsController {

    @Autowired
    private ShowAllBetsService showAllBetsService;

    @GetMapping(value = "/showAllBets")
    public String showAllBetsPage(ModelMap modelMap){
        ShowAllBetsResponse response = showAllBetsService.execute(new ShowAllBetsRequest());
        modelMap.addAttribute("bets",response.getShowAllBets());
        return "/showAllBets";
    }
}
