package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.services.dish.validators.GetDishByIdValidator;
import lv.javaguru.java2.wasterestarant.core.requests.dish.GetDishByIdRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetDishByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetDishByIdService {

    @Autowired private DishRepository dishRepository;

    @Autowired private GetDishByIdValidator validator;

    public GetDishByIdResponse execute(GetDishByIdRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()) {
            return new GetDishByIdResponse(errors);
        }
        return dishRepository.getById(request.getId())
                .map(GetDishByIdResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetDishByIdResponse(errors);
                });
    }
}

