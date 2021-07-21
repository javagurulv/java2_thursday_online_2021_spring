package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRepository;
import lv.javaguru.java2.wasterestarant.core.services.order.validators.GetOrderByIdValidator;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetOrderByIdRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetOrderByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetOrderByIdService {

    @Autowired private OrderRepository orderRepository;

    @Autowired private GetOrderByIdValidator validator;

    public GetOrderByIdResponse execute(GetOrderByIdRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetOrderByIdResponse(errors);
        }
        return orderRepository.getById(request.getId())
                .map(GetOrderByIdResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetOrderByIdResponse(errors);
                });
    }

}
