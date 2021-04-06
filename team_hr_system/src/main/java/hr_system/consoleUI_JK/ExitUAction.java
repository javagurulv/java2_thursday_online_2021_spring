package hr_system.consoleUI_JK;

public class ExitUAction implements UIAction {

    @Override
    public void perform() {
        System.out.println("Good bye!");
        System.exit(0);
    }
}