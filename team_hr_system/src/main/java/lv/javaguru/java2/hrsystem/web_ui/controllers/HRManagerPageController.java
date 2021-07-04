package lv.javaguru.java2.hrsystem.web_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HRManagerPageController {

    @GetMapping(value = "/hrManagerPage")
    public String signInPage() {
        return "hrManagerPage";
    }
}
