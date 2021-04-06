package console_ui;

import services.GetDishesByTypeService;

import java.util.Scanner;

public class GetDishesByTypeUIAction implements UIAction {

    private GetDishesByTypeService getDishesByTypeService;

    public GetDishesByTypeUIAction(GetDishesByTypeService getDishesByTypeService) {
        this.getDishesByTypeService = getDishesByTypeService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish type to show (starter, soup, main, pasta, or desert): ");
        String dishType = scanner.nextLine();
        System.out.println("Dishes by type: ");
        getDishesByTypeService.execute(dishType);

    }

}
