package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

@NoArgsConstructor
@Getter
public class GetUserResponse extends CoreResponse{
    private User user;

    public GetUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetUserResponse(User user) {
        this.user = user;
    }

}
