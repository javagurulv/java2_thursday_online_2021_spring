package lv.javaguru.java2.realestate.matchers;

import lv.javaguru.java2.realestate.core.domain.User;
import org.mockito.ArgumentMatcher;

public class UserMatcher implements ArgumentMatcher<User> {
    private String username;
    private String password;

    public UserMatcher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean matches(User user) {
        return user.getUsername().equals(username)
                && user.getPassword().equals(password);
    }
}
