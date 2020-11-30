package fr.insee.aventcalendar.controller;

import fr.insee.aventcalendar.service.*;
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

    @Autowired
    private MediaSectionService mediaSectionService;

    @Autowired
    private LanguageStyleService languageStyleService;

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String hello(Model model, @RequestParam(defaultValue = "2020") String year) throws IOException {
        model.addAttribute("persons", userService.getUserList(year));
        model.addAttribute("dateService", dateService);
        model.addAttribute("year", year);
        model.addAttribute("qanda", qAndAService.getQandA());
        model.addAttribute("mediaSection", mediaSectionService.getMediaSection());
        model.addAttribute("languageStyle", languageStyleService.getLanguageStyle());
        model.addAttribute("profiles", profileService.getUsersProfiles());
        return "index";
    }

}
