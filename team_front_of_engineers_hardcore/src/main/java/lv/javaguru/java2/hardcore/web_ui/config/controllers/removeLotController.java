package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.RemoveLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.RemoveLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class removeLotController {

    @Autowired
    private RemoveLotService removeLotService;

    @GetMapping(value = "/removeLot")
    public String removeLotPage(ModelMap modelMap){
        modelMap.addAttribute("request", new RemoveLotRequest());
        return "/removeLot";
    }

    @PostMapping(value = "/removeLot")
    public String processRemoveLot(@ModelAttribute(value = "request") RemoveLotRequest request,ModelMap modelMap){
        RemoveLotResponse response = removeLotService.execute(request);
        if(response.hasErrors()){
            modelMap.addAttribute("errors",response.getErrors());
            return "/removeLot";
        }else{
            return "redirect:/";
        }
    }
}
