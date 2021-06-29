package lv.javaguru.java2.realestate.controller;

import lv.javaguru.java2.realestate.core.domain.User;

public class UserNotFoundException extends RuntimeException {

    UserNotFoundException(User user) {
        super("Could not find user " + user.getUsername());
    }
}
