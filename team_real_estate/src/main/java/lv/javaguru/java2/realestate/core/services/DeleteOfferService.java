package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteOfferValidator;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class DeleteOfferService {
    @DIDependency
    private Database database;
    @DIDependency
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
