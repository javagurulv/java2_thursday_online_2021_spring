package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameOrPriceResponse;
import lv.javaguru.java2.hardcore.services.lot.SearchLotByNameOrPriceService;

import java.math.BigDecimal;
import java.util.Scanner;

public class SearchLotByNameOrPriceUIAction implements UIAction {

    private SearchLotByNameOrPriceService searchLotService;

    public SearchLotByNameOrPriceUIAction(SearchLotByNameOrPriceService searchLotService) {
        this.searchLotService = searchLotService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot name: ");
        String name = scanner.nextLine();
        System.out.println("Enter lot price");
        BigDecimal price = scanner.nextBigDecimal();
        SearchLotByNameOrPriceRequest request = new SearchLotByNameOrPriceRequest(name, price);
        SearchLotByNameOrPriceResponse response = searchLotService.execute(request);
        if (!response.getLots().isEmpty()) {
            System.out.println("Search result:");
            response.getLots().forEach(System.out::println);
            System.out.println("Search result end");
        } else {
            System.out.println("Nothing found!");
        }
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else response.getLots().forEach(Lot::toString);
    }
}
