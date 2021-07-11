package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.core.services.user.GetAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllUsersController {

    @Autowired GetAllUsersService getAllUsersService;

    @GetMapping(value = "/GetAllUsers")
    public String showAllUsersPage(ModelMap modelMap) {

    GetAllUsersResponse response  = getAllUsersService.execute();
    modelMap.addAttribute("users", response.getUsers());

    return "GetAllUsers";
    }
}
