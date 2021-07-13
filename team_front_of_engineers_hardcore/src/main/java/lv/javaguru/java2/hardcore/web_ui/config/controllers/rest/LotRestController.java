package lv.javaguru.java2.hardcore.web_ui.config.controllers.rest;

import lv.javaguru.java2.hardcore.core.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.core.requests.lot.GetLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.core.response.lot.GetLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.AddLotService;
import lv.javaguru.java2.hardcore.core.services.lot.GetLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lot")
public class LotRestController {

    @Autowired private GetLotService getLotService;
    @Autowired private AddLotService addLotService;

    @GetMapping(path = "/{id}",produces = "application/json")
    public GetLotResponse getLot(@PathVariable Long id){
        GetLotRequest request = new GetLotRequest(id);
        return getLotService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddLotResponse addLot(@RequestBody AddLotRequest request){
        return addLotService.execute(request);
    }



}

