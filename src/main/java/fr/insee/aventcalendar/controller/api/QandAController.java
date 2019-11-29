package fr.insee.aventcalendar.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.faq.QandA;
import fr.insee.aventcalendar.service.QAndAService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

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
