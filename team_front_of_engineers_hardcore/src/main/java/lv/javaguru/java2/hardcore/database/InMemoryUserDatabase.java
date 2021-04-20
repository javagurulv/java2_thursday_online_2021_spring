package lv.javaguru.java2.hardcore.database;


import lv.javaguru.java2.hardcore.datamodels.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDatabase implements UserDatabase {

    private Long nextId = 1L;
    private List<User> users = new ArrayList<>();



//    private boolean loggedIn;



    @Override
    public void addUser(User user) {
        user.setUserId(nextId);
        nextId++;
        users.add(user);
    }

    @Override
    public void logIn(User user) {
        if(users.contains(user)){
            System.out.println("Welcome: " + user.getName());
        }else{
            System.out.println("Username or password are incorrect,please try again");
        }

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }




}

