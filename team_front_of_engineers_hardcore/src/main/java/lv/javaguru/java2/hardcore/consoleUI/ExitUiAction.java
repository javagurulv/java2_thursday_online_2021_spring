package lv.javaguru.java2.hardcore.consoleUI;


import org.springframework.stereotype.Component;

@Component
public class ExitUiAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}
