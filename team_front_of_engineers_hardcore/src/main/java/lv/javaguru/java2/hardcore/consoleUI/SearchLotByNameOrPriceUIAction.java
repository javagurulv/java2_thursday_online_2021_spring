package lv.javaguru.java2.hardcore.consoleUI;


import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.requests.Ordering;
import lv.javaguru.java2.hardcore.core.requests.Paging;
import lv.javaguru.java2.hardcore.core.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.core.response.lot.SearchLotByNameOrPriceResponse;
import lv.javaguru.java2.hardcore.core.services.lot.SearchLotByNameOrPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class SearchLotByNameOrPriceUIAction implements UIAction {
    @Autowired
    private SearchLotByNameOrPriceService searchLotByNameOrPriceService;


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
        Paging paging = new Paging(pageNumber, pageSize);
        Ordering ordering = new Ordering(orderBy, orderDirection);
        SearchLotByNameOrPriceRequest request = new SearchLotByNameOrPriceRequest(nameOfLot, price, ordering, paging);
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
