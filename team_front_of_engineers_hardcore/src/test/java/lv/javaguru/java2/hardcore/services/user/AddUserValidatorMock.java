package lv.javaguru.java2.hardcore.services.user;

import lv.javaguru.java2.hardcore.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.util.List;

public class AddUserValidatorMock  extends  AddUserValidator{

    @Override
    public List<CoreError> validate(AddUserRequest request) {
        CoreError error = new CoreError("testE", "testA");
        return List.of(error);
    }
}
