package fr.insee.aventcalendar.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.insee.aventcalendar.model.leaderboard.UserList;

@Repository
public class UserLocal implements UserDAO {

	private static final String PERSONS_FILENAME = "persons.json";

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
		UserList userList = objectMapper.readValue(getClass().getResourceAsStream(dataLocation + PERSONS_FILENAME), UserList.class);
		return userList;
	}

}
