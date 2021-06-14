package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.core.services.user.GetAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsersUIAction implements UIAction{

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Override
    public void execute() {
        System.out.println("\n" + "Users list:");

        GetAllUsersResponse response = getAllUsersService.execute();
        if (response.hasUsers()) {
            response.getUsers().stream().map(user -> user.getId()
                    + " | " + user.getUserRole()
                    + " - " + user.getFirstName()
                    + " " + user.getLastName()).
                    forEach(System.out::println);
            System.out.println("---end of users list---" + "\n");
        }
        else {
            System.out.println("No users added at the moment");
        }
    }

    @Override
    public String toString() {
        return "Get all users";
    }
}
