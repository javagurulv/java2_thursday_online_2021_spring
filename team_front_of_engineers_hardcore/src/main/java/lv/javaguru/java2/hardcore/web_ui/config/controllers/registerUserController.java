package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.AddUserResponse;
import lv.javaguru.java2.hardcore.core.services.user.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class registerUserController {

    @Autowired
    private AddUserService addUserService;

    @GetMapping(value = "/registerUser")
        public String registerNewUserPage(ModelMap modelMap){
        modelMap.addAttribute("request" , new AddUserRequest());
        return "/registerUser";
    }

    @PostMapping(value = "/registerUser")
    public String processToRegisterNewUser(@ModelAttribute(value = "request") AddUserRequest request,ModelMap modelMap){
        AddUserResponse response = addUserService.execute(request);
        if(response.hasErrors()){
            modelMap.addAttribute("errors",response.getErrors());
            return "/registerUser";
        }else {
            return "redirect:/";
        }
    }

}
