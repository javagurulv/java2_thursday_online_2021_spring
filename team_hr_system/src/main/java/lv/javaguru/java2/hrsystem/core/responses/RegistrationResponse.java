package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.Admin;

import java.util.List;

public class RegistrationResponse extends CoreResponse{

    private Admin admin;

    public RegistrationResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegistrationResponse(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
}
