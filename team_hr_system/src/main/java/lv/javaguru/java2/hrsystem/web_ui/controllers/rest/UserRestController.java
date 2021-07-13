package lv.javaguru.java2.hrsystem.web_ui.controllers.rest;

import lv.javaguru.java2.hrsystem.core.requests.*;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired GetAllUsersService getAllUsersService;
    @Autowired UpdateUserRoleService updateUserRoleService;
    @Autowired DeleteUserService deleteUserService;

    @GetMapping(path = "/",
            produces = "application/json")
    public GetAllUsersResponse getAllUsers() {
        return getAllUsersService.execute();
    }

    @PutMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UpdateUserRoleResponse updateRole(@RequestBody UpdateUserRoleRequest request) {
        return updateUserRoleService.execute(request);
    }

    @DeleteMapping(path = "/{id}",
            produces = "application/json")
    public DeleteUserResponse deleteUser(@PathVariable Long id) {
        DeleteUserRequest request = new DeleteUserRequest(id);
        return deleteUserService.execute(request);
    }

}
