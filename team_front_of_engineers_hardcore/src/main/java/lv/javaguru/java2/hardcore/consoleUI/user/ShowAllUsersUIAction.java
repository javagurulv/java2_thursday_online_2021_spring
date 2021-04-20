package lv.javaguru.java2.hardcore.consoleUI.user;


import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.response.user.ShowAllUsersResponse;
import lv.javaguru.java2.hardcore.services.user.ShowAllUsersService;

public class ShowAllUsersUIAction implements UIAction {

    private ShowAllUsersService showAllUsersService;

    public ShowAllUsersUIAction(ShowAllUsersService showAllUsersService) {
        this.showAllUsersService = showAllUsersService;
    }

    @Override
    public void execute() {
        System.out.println("User list: ");
        ShowAllUserRequest request = new ShowAllUserRequest();
        ShowAllUsersResponse response = showAllUsersService.execute(request);
        response.getGetAllUsers().forEach(System.out::println);
        System.out.println("\nUser list end.");
    }
}
