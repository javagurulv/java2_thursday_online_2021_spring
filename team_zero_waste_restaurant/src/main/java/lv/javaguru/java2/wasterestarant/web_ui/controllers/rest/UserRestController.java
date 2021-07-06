package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;

import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.RegistrationResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangePasswordService;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangeUserRoleService;
import lv.javaguru.java2.wasterestarant.core.services.user.LoginService;
import lv.javaguru.java2.wasterestarant.core.services.user.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired private ChangeUserRoleService changeUserRoleService;
    @Autowired private ChangePasswordService changePasswordService;
    @Autowired private LoginService loginService;
    @Autowired private RegistrationService registrationService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public RegistrationResponse registrationResponse(@RequestBody RegistrationRequest request){
        return registrationService.execute(request);
    }
}
