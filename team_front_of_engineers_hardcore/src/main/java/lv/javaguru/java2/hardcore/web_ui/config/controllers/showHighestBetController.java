package lv.javaguru.java2.hardcore.web_ui.config.controllers;


import lv.javaguru.java2.hardcore.core.requests.bet.GetHighestBetByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetHighestBetByIdResponse;
import lv.javaguru.java2.hardcore.core.services.bet.GetHighestBetByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class showHighestBetController {

    @Autowired
    private GetHighestBetByIdService getHighestBetByIdService;

    @GetMapping(value = "/showHighestBet")
    public String getHighestBetPage(ModelMap modelMap){
        modelMap.addAttribute("request" ,new GetHighestBetByLotIdRequest());
        return "/showHighestBet";
    }

    @PostMapping(value = "/showHighestBet")
    public String processGetHighestBet (@ModelAttribute(value = "request") GetHighestBetByLotIdRequest request,ModelMap modelMap){
        GetHighestBetByIdResponse response = getHighestBetByIdService.execute(request);
        modelMap.addAttribute("bet",response.getBet());
        return "/showHighestBet";
    }
}

