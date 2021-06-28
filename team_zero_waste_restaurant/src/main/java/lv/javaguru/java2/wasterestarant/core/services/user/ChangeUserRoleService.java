package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangePasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ChangeUserRoleService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ChangeUserRoleValidator validator;

    public ChangePasswordResponse execute(ChangePasswordRequest request) {
        return null;
    }

}
