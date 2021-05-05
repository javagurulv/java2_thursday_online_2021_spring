package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.Ordering;
import lv.javaguru.java2.hardcore.requests.Paging;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameOrPriceResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchLotByNameOrPriceService {

    private LotDatabase lotDatabase;
    private SearchLotByNameOrPriceRequestValidator validator;

    public SearchLotByNameOrPriceService(LotDatabase lotDatabase, SearchLotByNameOrPriceRequestValidator validator) {
        this.lotDatabase = lotDatabase;
        this.validator = validator;
    }

    public SearchLotByNameOrPriceResponse execute(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchLotByNameOrPriceResponse(errors, null);
        }

        List<Lot> lots = search(request);
        lots = order(lots, request.getOrdering());
        lots = paging(lots,request.getPaging());

        return new SearchLotByNameOrPriceResponse(null, lots);
    }


    private List<Lot> order(List<Lot> lots, Ordering ordering) {
        if (ordering != null) {
            Comparator<Lot> comparator = ordering.getOrderBy().equals("name")
                    ? Comparator.comparing(Lot::getName)
                    : Comparator.comparing(Lot::getStartPrice);
            if (ordering.getOrderDirection().equals("DESC")) {
                comparator = comparator.reversed();
            }
            return lots.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return lots;
        }
    }


    private List<Lot> paging(List<Lot> lots, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return lots.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return lots;
        }
    }

    private List<Lot> search(SearchLotByNameOrPriceRequest request) {
        List<Lot> lots = new ArrayList<>();
        if (request.isNameProvided() && !request.isPriceProvided()) {
            lots = lotDatabase.searchByName(request.getName());
        }
        if (!request.isNameProvided() && request.isPriceProvided()) {
            lots = lotDatabase.searchByPrice(request.getPrice());
        }
        if (request.isNameProvided() && request.isPriceProvided()) {
            lots = lotDatabase.searchByNameAndPrice(request.getName(), request.getPrice());
        }
        return lots;
    }
}