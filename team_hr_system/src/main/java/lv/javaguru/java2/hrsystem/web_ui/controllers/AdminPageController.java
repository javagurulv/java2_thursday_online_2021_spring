package lv.javaguru.java2.hrsystem.web_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping(value = "/adminPage")
    public String signInPage() {
        return "adminPage";
    }
}
