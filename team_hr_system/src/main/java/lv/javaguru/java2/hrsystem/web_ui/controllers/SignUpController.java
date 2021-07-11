package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.RegisterUserResponse;
import lv.javaguru.java2.hrsystem.core.services.authorization.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired RegisterUserService registerUserService;

    @GetMapping(value = "/signUp")
    public String signUpPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RegisterUserRequest());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String processSignUpRequest(@ModelAttribute(value = "request") RegisterUserRequest request,
                                       ModelMap modelMap) {

        RegisterUserResponse response = registerUserService.execute(request);

        if(response.hasErrors()){
            modelMap.addAttribute("errors", response.getErrors());
            return "signUp";
        } else {
            return "redirect:/";
        }
    }
}
