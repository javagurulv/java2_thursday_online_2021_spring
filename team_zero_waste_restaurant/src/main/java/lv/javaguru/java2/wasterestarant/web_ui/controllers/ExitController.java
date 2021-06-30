package lv.javaguru.java2.wasterestarant.web_ui.controllers;

import lv.javaguru.java2.wasterestarant.console_ui.ExitUIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExitController {

    @Autowired
    ExitUIAction exitUIAction;

    @GetMapping(value = "/exit")
    public String exitApp(ModelMap modelMap) {
        exitUIAction.execute();
        return "redirect:/";
    }
}
