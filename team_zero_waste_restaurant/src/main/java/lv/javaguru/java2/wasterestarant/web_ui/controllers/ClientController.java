package lv.javaguru.java2.wasterestarant.web_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping(value = "/clientPage")
    public String Client() {
        return "clientPage";
    }
}

