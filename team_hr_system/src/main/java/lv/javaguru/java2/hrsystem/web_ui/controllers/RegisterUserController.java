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
public class RegisterUserController {

    @Autowired RegisterUserService registerUserService;

    @GetMapping(value = "/registerUser")
    public String registerUser(ModelMap modelMap) {
        modelMap.addAttribute("request", new RegisterUserRequest());
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String processRegisterUserRequest(@ModelAttribute(value = "request")
                                                         RegisterUserRequest registerUserRequest, ModelMap modelMap) {
        RegisterUserResponse registerUserResponse = registerUserService.execute(registerUserRequest);
        if(registerUserResponse.hasErrors()){
            modelMap.addAttribute("errors", registerUserResponse.getErrors());
            return "registerUser";
        } else {
            return "redirect:/";
        }
    }

}
