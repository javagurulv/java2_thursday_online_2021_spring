package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.ShowAllUsersResponse;
import lv.javaguru.java2.hardcore.core.services.user.ShowAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showAllUsersController {

    @Autowired
    private ShowAllUsersService showAllUsersService;

    @GetMapping(value = "/showAllUsers")
    public String showAllUsersPage(ModelMap modelMap){
        ShowAllUsersResponse response = showAllUsersService.execute(new ShowAllUserRequest());
        modelMap.addAttribute("users",response.getGetAllUsers());
        return "/showAllUsers";
    }


}
