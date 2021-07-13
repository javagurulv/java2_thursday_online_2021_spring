package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.DeleteUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteUserResponse;
import lv.javaguru.java2.hrsystem.core.services.user.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class DeleteUserController {

    @Autowired DeleteUserService deleteUserService;

    @GetMapping(value = "/DeleteUser")
    public String showDeleteUserPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new DeleteUserRequest());
        return "DeleteUser";
    }

    @PostMapping(value = "/DeleteUser")
    public String deleteUserPage(@ModelAttribute(value = "request") DeleteUserRequest request,
                                 ModelMap modelMap,
                                 HttpSession session) {

        DeleteUserResponse response = deleteUserService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "DeleteUser";
        } else {

            if (session.getAttribute("userRole").equals(UserRole.ADMIN)) {
                return "adminPage";
            } else {
                return "hrManagerPage";
            }
        }
    }
}
