package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.core.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.core.services.bet.AddBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addNewBetController {

    @Autowired
    private AddBetService addBetService;

    @GetMapping(value = "/addNewBet")
    public String showAddBetPage(ModelMap modelMap){
        modelMap.addAttribute("request",new AddBetRequest());
        return "addNewBet";
    }

    @PostMapping("/addNewBet")
    public String processAddBetRequest(@ModelAttribute(value = "request") AddBetRequest request,ModelMap modelMap){
        AddBetResponse response = addBetService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors",response.getErrors());
                return "addNewBet";
        } else{
            return "redirect:/";
        }
    }
}
