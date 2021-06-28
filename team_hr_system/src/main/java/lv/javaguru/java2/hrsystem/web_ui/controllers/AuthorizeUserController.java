package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.services.authorization.AuthorizeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizeUserController {

    @Autowired AuthorizeUserService authorizeUserService;

    @GetMapping(value = "/authorizeUser")
    public String registerUser(ModelMap modelMap) {
        modelMap.addAttribute("request", new AuthorizeUserRequest());
        return "authorizeUser";
    }

    @PostMapping("/authorizeUser")
    public String processAuthorizeUserRequest(@ModelAttribute(value = "request")
                                                          AuthorizeUserRequest authorizeUserRequest, ModelMap modelMap) {
        AuthorizeUserResponse authorizeUserResponse = authorizeUserService.execute(authorizeUserRequest);
        if(authorizeUserResponse.hasErrors()){
            modelMap.addAttribute("errors", authorizeUserResponse.getErrors());
            return "authorizeUser";
        } else {
            return "redirect:/";
        }
    }
}
