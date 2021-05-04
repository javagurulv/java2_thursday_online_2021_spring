package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class AddDishToWishlistValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(AddDishToWishlistRequest request) {
        validateClientID(request).ifPresent(errors::add);
        validateDishName(request).ifPresent(errors::add);
        validateQuantity(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientID(AddDishToWishlistRequest request) {
        return (request.getClientID() == null)
                ? Optional.of(new CoreError("ClientID", "Must not be null"))
                : Optional.empty();
    }

    private Optional<CoreError> validateDishName(AddDishToWishlistRequest request) {
        return (request.getDishName() == null || request.getDishName().isEmpty())
                ? Optional.of(new CoreError("DishName", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateQuantity(AddDishToWishlistRequest request) {
        return (request.getQuantity() <= 0)
                ? Optional.of(new CoreError("Quantity", "Must be a valid int value"))
                : Optional.empty();

    }

}
