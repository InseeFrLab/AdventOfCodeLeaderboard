package fr.insee.aventcalendar.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import fr.insee.aventcalendar.model.calendar.UserList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {
    private Cache<String, UserList> userCache;

    public CacheService(@Value("${cache.duration.minutes}") Integer cacheDuration) {
        this.userCache = CacheBuilder.newBuilder()
            .maximumSize(100)// Taille Max
            .expireAfterWrite(cacheDuration, TimeUnit.MINUTES)// TTL
            .build();
    }

    public Cache<String, UserList> getUserCache() {
        return userCache;
    }
}
