package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteOfferValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteOfferService {
    @Autowired
    private Database database;
    @Autowired
    private DeleteOfferValidator validator;

    public DeleteOfferResponse execute(DeleteOfferRequest deleteOfferRequest) {
        List<CoreError> errors = validator.validate(deleteOfferRequest);
        if (!errors.isEmpty()) {
            return new DeleteOfferResponse(errors);
        }

        boolean isOfferDeleted = database.deleteOfferByID(deleteOfferRequest.getId());

        return new DeleteOfferResponse(isOfferDeleted);
    }
}
