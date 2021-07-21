package lv.javaguru.java2.wasterestarant.web_ui.controllers.user;

import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangeUserRoleResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangeUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangeUserRoleController {
    @Autowired
    private ChangeUserRoleService service;

    @GetMapping(value = "/changeUserRole")
    public String showChangeUserRolePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new ChangeUserRoleRequest());
        return "changeUserRole";
    }

    @PostMapping("/changeUserRole")
    public String processChangeUserRoleRequest(@ModelAttribute(value = "request") ChangeUserRoleRequest request,
                                               ModelMap modelMap) {
        ChangeUserRoleResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "changeUserRole";
        } else {
            return "/changeUserRole";
        }
    }
}
