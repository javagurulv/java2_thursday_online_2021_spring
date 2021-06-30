package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.core.response.lot.GetAllLotsResponse;
import lv.javaguru.java2.hardcore.core.services.lot.GetAllLotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showAllLotsController {

    @Autowired private GetAllLotsService getAllLotsService;

    @GetMapping(value = "/showAllLots")
    public String showAllLots(ModelMap modelMap){
        GetAllLotsResponse response = getAllLotsService.execute(new GetAllLotsRequest());
        modelMap.addAttribute("lots" ,response.getGetAllLots());
        return "/showAllLots";
    }
}
