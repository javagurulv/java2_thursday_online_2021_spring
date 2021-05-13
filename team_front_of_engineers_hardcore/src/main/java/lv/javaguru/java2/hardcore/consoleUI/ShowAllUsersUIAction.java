package lv.javaguru.java2.hardcore.consoleUI;


import lv.javaguru.java2.hardcore.core.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.ShowAllUsersResponse;
import lv.javaguru.java2.hardcore.core.services.user.ShowAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllUsersUIAction implements UIAction {
    @Autowired
    private ShowAllUsersService showAllUsersService;


    @Override
    public void execute() {
        System.out.println("User list: ");
        ShowAllUserRequest request = new ShowAllUserRequest();
        ShowAllUsersResponse response = showAllUsersService.execute(request);
        response.getGetAllUsers().forEach(System.out::println);
        System.out.println("\nUser list end.");
    }
}
