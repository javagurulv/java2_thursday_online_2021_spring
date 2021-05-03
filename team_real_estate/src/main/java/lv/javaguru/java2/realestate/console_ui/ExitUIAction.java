package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.dependency_injection.DIComponent;

@DIComponent
public class ExitUIAction implements ConsoleUI {

    @Override
    public void execute() {
        System.exit(0);
        System.out.println("System closing..Bye!");
    }
}
