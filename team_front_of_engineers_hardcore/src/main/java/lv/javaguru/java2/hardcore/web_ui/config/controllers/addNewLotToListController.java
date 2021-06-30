package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.AddLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addNewLotToListController {

    @Autowired
    private AddLotService addLotService;

    @GetMapping(value = "/addNewLotToList")
    public String showAddLotPage(ModelMap modelMap){
        modelMap.addAttribute("request",new AddLotRequest());
        return "addNewLotToList";
    }

    @PostMapping("/addNewLotToList")
    public String processAddLotRequest(@ModelAttribute(value = "request") AddLotRequest request,ModelMap modelMap){
        AddLotResponse response = addLotService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addNewLotToList";
        } else {
            return "redirect:/";
        }
    }

}
