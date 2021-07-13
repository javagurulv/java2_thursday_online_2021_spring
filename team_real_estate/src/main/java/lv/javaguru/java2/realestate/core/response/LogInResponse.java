package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

@NoArgsConstructor
@Getter
public class LogInResponse extends CoreResponse {
    private User user;
    private boolean isLoggedIn = false;

    public LogInResponse(List<CoreError> errors) {
        super(errors);
    }

    public LogInResponse(User user, boolean isLoggedIn) {
        this.user = user;
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

}
