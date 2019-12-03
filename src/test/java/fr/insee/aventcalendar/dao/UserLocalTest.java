package fr.insee.aventcalendar.dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.calendar.User;
import fr.insee.aventcalendar.model.calendar.UserList;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLocalTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private UserLocal userLocal;

    @Test
    public void shallGetNotNullButEmpty() throws IOException {
        UserList myUserList = new UserList();
        myUserList.setData(new HashMap<String, User>());
        objectMapper = new ObjectMapper() {
            @Override
            public <T> T readValue(InputStream src, Class<T> valueType) throws IOException, JsonParseException, JsonMappingException {
                return (T) myUserList;
            }
        };
        userLocal.setObjectMapper(objectMapper);
        List<String> list = new ArrayList<String>();
        assertAll("mocked class",
                () -> assertNotNull(userLocal.getUsers("2018")),
                () -> assertNotNull(userLocal.getUsers("2018").getMembers()),
                () -> assertEquals(0, userLocal.getUsers("2018").getMembers().size()));
    }
}