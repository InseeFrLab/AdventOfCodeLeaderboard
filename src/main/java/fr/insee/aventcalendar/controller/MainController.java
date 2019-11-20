package fr.insee.aventcalendar.controller;

import fr.insee.aventcalendar.service.DateService;
import fr.insee.aventcalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private DateService dateService;

    @GetMapping
    public String hello(Model model, @RequestParam(defaultValue = "2018") String year) throws IOException {
        model.addAttribute("persons", userService.getUserList(year));
        model.addAttribute("dateService", dateService);
        model.addAttribute("year", year);
        return "index";
    }

}
