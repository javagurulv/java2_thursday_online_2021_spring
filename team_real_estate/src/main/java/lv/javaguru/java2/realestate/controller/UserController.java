package lv.javaguru.java2.realestate.controller;

import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.requests.GetUserRequest;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.response.GetUserResponse;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.CreateUserService;
import lv.javaguru.java2.realestate.core.services.DeleteUserService;
import lv.javaguru.java2.realestate.core.services.GetUserService;
import lv.javaguru.java2.realestate.core.services.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private LogInService logInService;

    @Autowired
    private DeleteUserService deleteUserService;

    @Autowired
    private GetUserService getUserService;

    @PostMapping("/add_to_registered_user")
    @ResponseBody
    public String newUser(@RequestBody User newUser) {
        CreateUserResponse response = createUserService.execute(
                new CreateUserRequest(newUser.getUsername(),newUser.getPassword()));
        if(response.hasErrors()){
            StringBuilder errors = new StringBuilder();

            for(int i = 0; i< response.getErrors().size(); i++){
                errors.append(response.getErrors().get(i).getField());
                errors.append(" ");
                errors.append(response.getErrors().get(i).getMessage());
            }

            return errors.toString();
        } else {
            return "Account created";
        }
    }

    @PostMapping("/find_in_registered_user")
    @ResponseBody
    public String LogIn(@RequestBody User targetUser) {
        LogInResponse response = logInService.execute(
                new LogInRequest(targetUser.getUsername(),targetUser.getPassword()));
        if(response.hasErrors()){
            StringBuilder errors = new StringBuilder();

            for(int i = 0; i< response.getErrors().size(); i++){
                errors.append(response.getErrors().get(i).getField());
                errors.append(" ");
                errors.append(response.getErrors().get(i).getMessage());
            }
            return errors.toString();
        } else if(response.isLoggedIn()) {
            return "true";
        } else {
            return "Incorrect username or password";
        }
    }

    @PostMapping("/delete_from_registered_user")
    @ResponseBody
    public String deleteUser(@RequestBody User targetUser) {
        DeleteUserResponse response = deleteUserService.execute(
                new DeleteUserRequest(targetUser.getUsername(), targetUser.getPassword()));
        if (response.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for(int i = 0; i< response.getErrors().size(); i++){
                errors.append(response.getErrors().get(i).getField());
                errors.append(" ");
                errors.append(response.getErrors().get(i).getMessage());
            }
            return errors.toString();
        } else if(response.isUserDeleted()){
            return "Account deleted successfully!";
        } else {
            return "Failed to delete account";
        }
    }

    @PostMapping("/get_user")
    @ResponseBody
    public User getUser(@RequestBody User targetUser) throws ResponseErrors{
        GetUserResponse response = getUserService.execute(
                new GetUserRequest(targetUser.getUsername(), targetUser.getPassword()));
        if (response.hasErrors()){
            throw new ResponseErrors(response.getErrors());
        } else {
            return response.getUser();
        }
    }

    @ExceptionHandler(ResponseErrors.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String handleSomeException(ResponseErrors ex)
    {
        return ex.getErrors().stream().map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
