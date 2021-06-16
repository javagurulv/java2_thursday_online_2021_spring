package lv.javaguru.java2.realestate.controller;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private OfferRepository offerRepository;

    @GetMapping("/get_all_offers")
    List<Offer> offerList(){
        return offerRepository.getAllOffers();
    }


    @PostMapping("/add_to_registered_user")
    void newUser(@RequestBody String username, String password) {
        User newUser = new User(username,password);
        userRepository.createAccount(newUser);
    }

    @GetMapping("/find_in_registered_user")
    boolean findUser(@RequestBody String username, String password){
        User targetUser = new User(username,password);
        if(userRepository.logIn(targetUser)) {
            return true;
        } else throw new UserNotFoundException(targetUser);
    }

    @DeleteMapping("/delete_from_registered_user")
    boolean deleteUser(@RequestBody String username, String password){
        User targetUser = new User(username,password);
        if(userRepository.deleteUser(targetUser)) {
            return true;
        } else throw new UserNotFoundException(targetUser);
    }
}
