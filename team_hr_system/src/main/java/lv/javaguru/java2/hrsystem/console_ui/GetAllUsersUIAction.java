package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.core.services.GetAllUsersService;

public class GetAllUsersUIAction implements UIAction{

    private GetAllUsersService getAllUsersService;

   /* public GetAllUsersUIAction(GetAllUsersService getAllUsersService) {
        this.getAllUsersService = getAllUsersService;
    }*/

    @Override
    public void execute() {
        System.out.println("\n" + "Users list:");
//        GetAllUsersRequest request = new GetAllUsersRequest();
        GetAllUsersResponse response = getAllUsersService.execute();
        if (response.hasUsers()) {
            response.getUsers().stream().map(user -> user.getId()
                    + " | " + user.getUserRole()
                    + " - " + user.getFirstName()
                    + " " + user.getSecondName()).
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
