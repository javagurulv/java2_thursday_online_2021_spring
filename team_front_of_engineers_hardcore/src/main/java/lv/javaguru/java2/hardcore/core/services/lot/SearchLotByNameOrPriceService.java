package lv.javaguru.java2.hardcore.core.services.lot;

import lv.javaguru.java2.hardcore.core.database.LotRepository;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.requests.Ordering;
import lv.javaguru.java2.hardcore.core.requests.Paging;
import lv.javaguru.java2.hardcore.core.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.lot.SearchLotByNameOrPriceResponse;
import lv.javaguru.java2.hardcore.core.services.lot.validators.SearchLotByNameOrPriceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Transactional
public class SearchLotByNameOrPriceService {
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private SearchLotByNameOrPriceRequestValidator validator;

    public SearchLotByNameOrPriceResponse execute(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchLotByNameOrPriceResponse(errors, null);
        }

        List<Lot> lots = search(request);
        lots = order(lots, request.getOrdering());
        lots = paging(lots, request.getPaging());

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
            lots = lotRepository.searchByName(request.getName());
        }
        if (!request.isNameProvided() && request.isPriceProvided()) {
            lots = lotRepository.searchByPrice(request.getPrice());
        }
        if (request.isNameProvided() && request.isPriceProvided()) {
            lots = lotRepository.searchByNameAndPrice(request.getName(), request.getPrice());
        }
        return lots;
    }
}
