package consoleUI;

public class ExitUiAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}
