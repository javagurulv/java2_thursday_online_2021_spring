package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllUsersRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.User;

import java.util.List;

@DIComponent
public class GetAllUsersService {

    @DIDependency
    private Database database;

  /*  public GetAllUsersService(Database database) {
        this.database = database;
    }*/

    public GetAllUsersResponse execute() {
        List<User> userList = database.getAllUsers();
        return new GetAllUsersResponse(userList);
    }
}
