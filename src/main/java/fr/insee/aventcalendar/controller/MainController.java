package fr.insee.aventcalendar.controller;

import fr.insee.aventcalendar.service.DateService;
import fr.insee.aventcalendar.service.QAndAService;
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

    @Autowired
    private QAndAService qAndAService;

    @GetMapping
    public String hello(Model model, @RequestParam(defaultValue = "2019") String year) throws IOException {
        model.addAttribute("persons", userService.getUserList(year));
        model.addAttribute("dateService", dateService);
        model.addAttribute("year", year);
        model.addAttribute("qanda", qAndAService.getQandA());
        return "index";
    }

}
