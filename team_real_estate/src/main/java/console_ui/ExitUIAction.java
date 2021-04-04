package console_ui;

class ExitUIAction implements  ConsoleUI{

    @Override
    public void execute() {
        System.exit(0);
        System.out.println("System closing..Bye!");
    }
}
