package lv.javaguru.java2.realestate.controller;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.*;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.CreateOfferService;
import lv.javaguru.java2.realestate.core.services.DeleteOfferService;
import lv.javaguru.java2.realestate.core.services.GetAllOffersService;
import lv.javaguru.java2.realestate.core.services.SearchOffersService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
public class OfferController {

    @Autowired
    private GetAllOffersService getAllOffersService;

    @Autowired
    private CreateOfferService createOfferService;

    @Autowired
    private DeleteOfferService deleteOfferService;

    @Autowired
    private SearchOffersService searchOffersService;

    @GetMapping("/get_all_offers")
    @ResponseBody
    public List<Offer> getAllOffers() {
        return getAllOffersService.execute(
                new GetAllOffersRequest()).getOfferList();
    }

    @PostMapping("/search_offers")
    @ResponseBody
    public List<?> searchOffers(@RequestBody SearchOffersRequest searchOffersRequest) {
        SearchOffersResponse response = searchOffersService.execute(searchOffersRequest);
        if(response.hasErrors()) {
           return response.getErrors();
        } else {
            return response.getFoundOffers();
        }
    }

    @PostMapping("/create_offer")
    public String createOffer(@RequestBody Offer newOffer) {
        CreateOfferResponse response = createOfferService.execute(new CreateOfferRequest(
                newOffer.getOfferType(), newOffer.getOfferCategory(), newOffer.getDescription(), newOffer.getPrice()));
        if(response.hasErrors()){
            StringBuilder errors = new StringBuilder();

            for(int i = 0; i< response.getErrors().size(); i++){
                errors.append(response.getErrors().get(i).getField());
                errors.append(" ");
                errors.append(response.getErrors().get(i).getMessage());
            }

            return errors.toString();
        } else {
            return "Offer created";
        }
    }

    @PostMapping("/delete_offer")
    @ResponseBody
    public String deleteOffer(@RequestBody String id) {
        System.out.println("ID FROM request = "+id);

        int idInt = new JSONObject(id).getInt("id");
        System.out.println("ID FROM parser = "+idInt);

                DeleteOfferResponse response = deleteOfferService.execute(
                new DeleteOfferRequest(idInt));
        if(response.hasErrors()){
            StringBuilder errors = new StringBuilder();

            for(int i = 0; i< response.getErrors().size(); i++){
                errors.append(response.getErrors().get(i).getField());
                errors.append(" ");
                errors.append(response.getErrors().get(i).getMessage());
            }

            return errors.toString();
        } else {
            return "Offer deleted";
        }
    }

}
