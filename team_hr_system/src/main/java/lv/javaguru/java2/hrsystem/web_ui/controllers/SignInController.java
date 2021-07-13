package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.services.authorization.AuthorizeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {

    @Autowired AuthorizeUserService authorizeUserService;

    @GetMapping(value = "/signIn")
    public String signInPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AuthorizeUserRequest());
        return "signIn";
    }

    @PostMapping("/signIn")
    public String processSignInRequest(@ModelAttribute(value = "request") AuthorizeUserRequest request,
                                       ModelMap modelMap,
                                       HttpSession session) {

        AuthorizeUserResponse response = authorizeUserService.execute(request);

        if(response.hasErrors()){

            modelMap.addAttribute("errors", response.getErrors());
            return "signIn";

        } else {

            if (response.getAuthorization().get().getUserRole().equals(UserRole.ADMIN)) {

                session.setAttribute("userRole", response.getAuthorization().get().getUserRole());

                return "adminPage";

            } else if (response.getAuthorization().get().getUserRole().equals(UserRole.HR_MANAGER)) {

                session.setAttribute("userRole", response.getAuthorization().get().getUserRole());

                return "hrManagerPage";

            } else {

                return "redirect:/";
            }
        }
    }
}
