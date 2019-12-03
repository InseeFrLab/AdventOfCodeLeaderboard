package fr.insee.aventcalendar.controller.api;

import fr.insee.aventcalendar.model.faq.QandA;
import fr.insee.aventcalendar.service.QAndAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/qanda")
public class QandAController {

    @Autowired
    private QAndAService qAndAService;


    @GetMapping
    public QandA getQandA() throws IOException {
        return qAndAService.getQandA();
    }
}
