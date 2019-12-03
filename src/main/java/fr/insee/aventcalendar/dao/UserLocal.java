package fr.insee.aventcalendar.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.calendar.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class UserLocal implements UserDAO {

    private ObjectMapper objectMapper;
    @Value("${assets.data.location}")
    private String dataLocation;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public UserLocal(ObjectMapper newObjectMapper) {
        objectMapper = newObjectMapper;
    }

    @Override
    public UserList getUsers(String year) throws IOException {
        UserList userList = objectMapper.readValue(getClass().getResourceAsStream(dataLocation+"persons.json"), UserList.class);
        return userList;
    }

}
