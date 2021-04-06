package consoleUI;

import Services.GetAllLotsService;

public class GetAllLotsUIAction implements UIAction {

    private GetAllLotsService getAllLotsService;

    public GetAllLotsUIAction(GetAllLotsService getAllLotsService) {
        this.getAllLotsService = getAllLotsService;
    }

    @Override
    public void execute() {
        System.out.println("DataModels.Lot list: ");
        getAllLotsService.execute().forEach(System.out::println);
        System.out.println("\nDataModels.Lot list end.");
    }
}
