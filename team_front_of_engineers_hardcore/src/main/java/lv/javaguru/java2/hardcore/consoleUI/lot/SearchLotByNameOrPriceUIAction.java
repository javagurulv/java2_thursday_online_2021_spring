package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.Ordering;
import lv.javaguru.java2.hardcore.requests.Paging;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameOrPriceResponse;
import lv.javaguru.java2.hardcore.services.lot.SearchLotByNameOrPriceService;

import java.math.BigDecimal;
import java.util.Scanner;

public class SearchLotByNameOrPriceUIAction implements UIAction {

    private SearchLotByNameOrPriceService searchLotByNameOrPriceService;

    public SearchLotByNameOrPriceUIAction(SearchLotByNameOrPriceService searchLotByNameOrPriceService) {
        this.searchLotByNameOrPriceService = searchLotByNameOrPriceService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot name: ");
        String nameOfLot = scanner.nextLine();
        System.out.println("Enter lot price");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Enter sortBY:(name/price)");
        String orderBy = scanner.nextLine();
        System.out.println("Enter ASC or DESC");
        String orderDirection = scanner.nextLine();
        System.out.println("Enter page number");
        Integer pageNumber = scanner.nextInt();
        System.out.println("Enter page size");
        Integer pageSize = scanner.nextInt();
        Paging paging = new Paging(pageNumber,pageSize);
        Ordering ordering = new Ordering(orderBy, orderDirection);
        SearchLotByNameOrPriceRequest request = new SearchLotByNameOrPriceRequest(nameOfLot, price,ordering,paging);
        SearchLotByNameOrPriceResponse response = searchLotByNameOrPriceService.execute(request);
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