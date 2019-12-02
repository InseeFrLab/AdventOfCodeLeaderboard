package fr.insee.aventcalendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.faq.QandA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QAndAService {

    @Value("${qanda.location}")
    private String qandALocation;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper mapper;

    private QandA quandACache;

    public QandA getQandA() throws IOException {
        if (quandACache != null) {
            return quandACache;
        }
        quandACache =  mapper.readValue(resourceLoader.getResource(qandALocation).getInputStream(), QandA.class);
        return quandACache;
    }
}
