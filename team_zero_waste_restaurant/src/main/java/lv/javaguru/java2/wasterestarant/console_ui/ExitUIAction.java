package lv.javaguru.java2.wasterestarant.console_ui;

public class ExitUIAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Goodbye! See you later!");
        System.exit(0);
    }
}

