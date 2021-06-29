package lv.javaguru.java2.realestate.controller;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OfferController {

    @Autowired private OfferRepository offerRepository;

    @GetMapping("/get_all_offers")
    public @ResponseBody
    List<Offer> getAllOffers(){
        return  offerRepository.getAllOffers();
    }

    @GetMapping("/search_offers")
    public @ResponseBody
    List<Offer> searchOffers(@RequestBody SearchOffersRequest searchOffersRequest){
        return  offerRepository.searchOffers(searchOffersRequest);
    }

    @PostMapping("/create_offer")
    public void createOffer(@RequestBody Offer newOffer){
        offerRepository.createOffer(newOffer);
    }

    @DeleteMapping("/delete_offer")
    public @ResponseBody boolean deleteOffer(@RequestBody int id){
        return offerRepository.deleteOfferByID(id);
    }

}
