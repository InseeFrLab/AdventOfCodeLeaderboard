package fr.insee.aventcalendar.dao;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.insee.aventcalendar.model.leaderboard.User;
import fr.insee.aventcalendar.model.leaderboard.UserList;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserLocalTest {

	@InjectMocks
	private UserLocal userLocal;

	@Mock
	private ObjectMapper objectMapper;

	@Test
	public void shallGetNotNullButEmpty() throws IOException {
		UserList myUserList = new UserList();
		myUserList.setData(new HashMap<String, User>());
		
		
		/* When call method object.mapper(<InputStream>, UserList.class) return always myUserList
		 * It's necessary to explicitly define the case of call to object.mapper((InputStream) null, UserList.class) 
		 * because it's ambiguous with call of object.mapper((JsonParser) null, UserList.class) */
		doReturn(myUserList)
			.when(objectMapper)
			.readValue( or(isA(InputStream.class), eq((InputStream) null)), eq(UserList.class)) ;

        assertAll("mocked class",
                () -> assertNotNull(userLocal.getUsers("2018")),
                () -> assertNotNull(userLocal.getUsers("2018").getMembers()),
                () -> assertEquals(0, userLocal.getUsers("2018").getMembers().size()));
	}
}