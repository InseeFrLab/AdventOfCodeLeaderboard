package fr.insee.aventcalendar.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.UserList;
import fr.insee.aventcalendar.service.CacheService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@Primary
public class UserRemote implements UserDAO {

    private OkHttpClient client;
    private ObjectMapper objectMapper;
    private CacheService cache;

    @Value("${data.remote.host}")
    private String dataRemoteUrl;
    @Value("${private.group.id}")
    private String groupId;

    @Autowired
    public UserRemote(OkHttpClient client, ObjectMapper newObjectMapper, CacheService cacheService) {
        this.client = client;
        this.objectMapper = newObjectMapper;
        this.cache = cacheService;
    }

    @Override
    public UserList getUsers(String year) throws IOException {
        UserList myValue = this.cache.getUserCache().getIfPresent(year);
        if (myValue == null) {
            String str = run(dataRemoteUrl.replace("{YEAR}", year).replace("{GROUP_ID}", groupId));
            UserList userList = objectMapper.readValue(str, UserList.class);
            this.cache.getUserCache().put(year, userList);
            return userList;
        };
        return myValue;
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = this.client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}