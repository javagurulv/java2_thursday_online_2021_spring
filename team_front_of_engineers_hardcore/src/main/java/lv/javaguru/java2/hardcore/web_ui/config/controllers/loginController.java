package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import lv.javaguru.java2.hardcore.core.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.core.response.user.LoginResponse;
import lv.javaguru.java2.hardcore.core.services.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String loginPage(ModelMap modelMap){
        modelMap.addAttribute("request" , new LoginRequest());
        return "/login";
    }

    @PostMapping(value = "/login")
    public String processToLogin(@ModelAttribute(value = "request") LoginRequest request,ModelMap modelMap){
                LoginResponse response = loginService.execute(request);
                if(response.hasErrors()){
                    modelMap.addAttribute("errors",response.getErrors());
                    return "/login";
                }else{
                    return "redirect:/";
                }
    }
}
