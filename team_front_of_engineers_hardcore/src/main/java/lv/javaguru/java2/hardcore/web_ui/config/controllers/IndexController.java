package lv.javaguru.java2.hardcore.web_ui.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
