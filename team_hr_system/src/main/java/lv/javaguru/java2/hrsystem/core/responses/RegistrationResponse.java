package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.Admin;

public class RegistrationResponse {

    private Admin admin;

    public RegistrationResponse(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {

        return admin;

    }
}
