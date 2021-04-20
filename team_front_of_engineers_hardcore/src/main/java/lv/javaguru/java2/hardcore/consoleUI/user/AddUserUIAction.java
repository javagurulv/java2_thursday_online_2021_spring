package lv.javaguru.java2.hardcore.consoleUI.user;



import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.AddUserResponse;
import lv.javaguru.java2.hardcore.services.user.AddUserService;

import java.util.Scanner;

public class AddUserUIAction implements UIAction {

    private AddUserService addUserService;

    public AddUserUIAction(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter account name: ");
        String acc = scanner.nextLine();
        System.out.println("Please enter password: ");
        String pas = scanner.nextLine();
        AddUserRequest request = new AddUserRequest(acc,pas);
        AddUserResponse response = addUserService.execute(request);
        if(response.hasErrors()){
            response.getErrors().forEach(coreError -> System.out.println("Error: "+coreError.getField()+" "+coreError.getMessage()));
        }
        System.out.println("Account: "+response.getNewUser());
        System.out.println("Was added!");
    }
}
