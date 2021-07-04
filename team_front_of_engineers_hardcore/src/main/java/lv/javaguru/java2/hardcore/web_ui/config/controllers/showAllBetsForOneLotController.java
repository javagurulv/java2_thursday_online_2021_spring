package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.bet.GetAllBetsForLotByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetAllBetsForLotByLotIdResponse;
import lv.javaguru.java2.hardcore.core.services.bet.GetAllBetsByLotIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class showAllBetsForOneLotController {

    @Autowired
    private GetAllBetsByLotIdService getAllBetsByLotIdService;

    @GetMapping(value = "/showAllBetsForOneLot")
    public String showAllBetsForOneLotPage(ModelMap modelMap){
        modelMap.addAttribute("request",new GetAllBetsForLotByLotIdRequest());
        return "/showAllBetsForOneLot";
    }

    @PostMapping(value = "/showAllBetsForOneLot")
    public String processShowAllBetsForOneLot(@ModelAttribute(value = "request") GetAllBetsForLotByLotIdRequest request,ModelMap modelMap){
        GetAllBetsForLotByLotIdResponse response = getAllBetsByLotIdService.execute(request);
        modelMap.addAttribute("bets",response.getGetAllBetsByLotId());
        return "/showAllBetsForOneLot";
    }
}
