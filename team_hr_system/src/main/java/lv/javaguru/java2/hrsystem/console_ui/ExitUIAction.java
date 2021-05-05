package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;

@DIComponent
public class ExitUIAction implements UIAction{
    @Override
    public void execute() {
        System.out.println("Good bye!");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
