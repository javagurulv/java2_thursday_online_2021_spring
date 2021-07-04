package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.core.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.core.response.bet.RemoveBetResponse;
import lv.javaguru.java2.hardcore.core.services.bet.RemoveBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class removeBetController {

    @Autowired
    private RemoveBetService removeBetService;

    @GetMapping(value = "/removeBet")
    public String removeBetPage(ModelMap modelMap){
        modelMap.addAttribute("request",new RemoveBetRequest());
        return "/removeBet";
    }

    @PostMapping(value = "/removeBet" )
    public String processRemoveBet(@ModelAttribute(value = "request") RemoveBetRequest request, ModelMap modelMap){
        RemoveBetResponse response = removeBetService.execute(request);
        if(response.hasErrors()){
            modelMap.addAttribute("errors",response.getErrors());
            return "/removeBet";
        }else{
            return "redirect:/";
        }
    }
}
