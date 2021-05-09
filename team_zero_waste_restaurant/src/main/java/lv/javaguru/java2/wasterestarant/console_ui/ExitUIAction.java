package lv.javaguru.java2.wasterestarant.console_ui;

import org.springframework.stereotype.Component;

@Component
public class ExitUIAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Goodbye! See you later!");
        System.exit(0);
    }
}

