package lv.javaguru.java2.hardcore.database;


import lv.javaguru.java2.hardcore.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDatabase implements UserDatabase {

    private Long nextId = 1L;
    private List<User> users = new ArrayList<>();
    private Long userID;


    @Override
    public void addUser(User user) {
        user.setUserId(nextId);
        userID = user.getUserId();
        nextId++;
        users.add(user);
    }

    @Override
    public void logIn(User user) {
        if (users.contains(user)) {
            System.out.println("Welcome: " + user.getName());
        } else {
            System.out.println("Username or password are incorrect,please try again");
        }

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


    @Override
    public Long getUserId() {
        return userID;
    }
}

