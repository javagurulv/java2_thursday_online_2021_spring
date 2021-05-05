package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.util.List;

public class AddLotValidatorMock extends AddLotValidator {

    @Override
    public List<CoreError> validate(AddLotRequest request) {
        CoreError errors = new CoreError("testField", "testMessage");
        return List.of(errors);
    }
}
