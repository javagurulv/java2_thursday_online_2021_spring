package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;

import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangePasswordResponse;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangeUserRoleResponse;
import lv.javaguru.java2.wasterestarant.core.responses.user.LoginResponse;
import lv.javaguru.java2.wasterestarant.core.responses.user.RegistrationResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangePasswordService;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangeUserRoleService;
import lv.javaguru.java2.wasterestarant.core.services.user.LoginService;
import lv.javaguru.java2.wasterestarant.core.services.user.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired private ChangeUserRoleService changeUserRoleService;
    @Autowired private ChangePasswordService changePasswordService;
    @Autowired private LoginService loginService;
    @Autowired private RegistrationService registrationService;

    @PostMapping(path = "/userRegistration",
            consumes = "application/json",
            produces = "application/json")
    public RegistrationResponse registrationResponse(@RequestBody RegistrationRequest request){
        return registrationService.execute(request);
    }

    @PutMapping(path = "/changeUserRole",
            consumes = "application/json",
            produces = "application/json")
    public ChangeUserRoleResponse changeUserRole(@RequestBody ChangeUserRoleRequest request){
        return changeUserRoleService.execute(request);
    }

    @PutMapping(path = "/changePassword",
            consumes = "application/json",
            produces = "application/json")
    public ChangePasswordResponse changePassword (@RequestBody ChangePasswordRequest request){
        return changePasswordService.execute(request);
    }

    @PostMapping(path = "/userLogin",
            consumes = "application/json",
            produces = "application/json")
    public LoginResponse login (@RequestBody LoginRequest request){
        return loginService.execute(request);
    }

}
