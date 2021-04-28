package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameRequest;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameResponse;
import lv.javaguru.java2.hardcore.services.lot.SearchLotByNameService;

import java.util.Scanner;

public class SearchLotByNameUIAction implements UIAction {

    private SearchLotByNameService searchLotService;

    public SearchLotByNameUIAction(SearchLotByNameService searchLotService) {
        this.searchLotService = searchLotService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot name: ");
        String name = scanner.nextLine();
        SearchLotByNameRequest request = new SearchLotByNameRequest(name);
        SearchLotByNameResponse response = searchLotService.execute(request);
        if(!response.getLots().isEmpty()){
            System.out.println("Search result:");
            response.getLots().forEach(System.out::println);
            System.out.println("Search result end");
        }else{
            System.out.println("Nothing found!");
        }
        if(response.hasErrors()){
            response.getErrors().forEach(coreError -> System.out.println("Error: "+coreError.getField()+" "+coreError.getMessage()));
        }else response.getLots().forEach(Lot::toString);
    }
}
