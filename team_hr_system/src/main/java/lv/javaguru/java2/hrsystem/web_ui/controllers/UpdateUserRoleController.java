package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.UpdateUserRoleRequest;
import lv.javaguru.java2.hrsystem.core.responses.UpdateUserRoleResponse;
import lv.javaguru.java2.hrsystem.core.services.user.UpdateUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UpdateUserRoleController {

    @Autowired UpdateUserRoleService updateUserRoleService;

    @GetMapping(value = "/UpdateUserRole")
    public String showUserRolePge(ModelMap modelMap) {
        modelMap.addAttribute("request", new UpdateUserRoleRequest());

        return "UpdateUserRole";
    }

    @PostMapping(value = "/UpdateUserRole")
    public String updateUserRolePage(@ModelAttribute(value = "request") UpdateUserRoleRequest request,
                                     ModelMap modelMap,
                                     HttpSession session) {

        UpdateUserRoleResponse response = updateUserRoleService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "UpdateUserRole";
        } else {

            if (session.getAttribute("userRole").equals(UserRole.ADMIN)) {
                return "adminPage";
            } else {
                return "hrManagerPage";
            }
        }
    }
}
