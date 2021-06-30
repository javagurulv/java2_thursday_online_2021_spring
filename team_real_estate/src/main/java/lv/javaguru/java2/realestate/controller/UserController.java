package lv.javaguru.java2.realestate.controller;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add_to_registered_user")
    public void newUser(@RequestBody User newUser) {
        userRepository.createAccount(newUser);
    }

    @GetMapping("/find_in_registered_user")
    @ResponseBody
    public boolean findUser(@RequestBody User targetUser) {
        if (userRepository.logIn(targetUser)) {
            return true;
        } else throw new UserNotFoundException(targetUser);
    }

    @DeleteMapping("/delete_from_registered_user")
    @ResponseBody
    public boolean deleteUser(@RequestBody User targetUser) {
        if (userRepository.deleteUser(targetUser)) {
            return true;
        } else throw new UserNotFoundException(targetUser);
    }
}
