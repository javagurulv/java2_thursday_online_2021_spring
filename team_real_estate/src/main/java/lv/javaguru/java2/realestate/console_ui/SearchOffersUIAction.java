package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.Paging;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.SearchOffersService;

import java.util.Scanner;

public class SearchOffersUIAction implements ConsoleUI {

    SearchOffersService searchOffersService;

    public SearchOffersUIAction(SearchOffersService searchOffersService) {
        this.searchOffersService = searchOffersService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to skip field");

        System.out.println("Enter Offer type");
        String type = scanner.nextLine();
        System.out.println("Enter Offer category");
        String category = scanner.nextLine();
        System.out.println("Enter Offer price");
        String stringPrice = scanner.nextLine();
        Double price = 0.0;

        if (!"".equals(stringPrice)) {
            price = Double.parseDouble(stringPrice);
        }

        System.out.println("Enter orderBy (type||category||price): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchOffersRequest request = new SearchOffersRequest(type, category, price, ordering, paging);
        SearchOffersResponse response = searchOffersService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getFoundOffers().forEach(offer -> System.out.println(offer.toString()));
        }
    }

}

