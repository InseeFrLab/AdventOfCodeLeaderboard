package fr.insee.aventcalendar.dao;

import fr.insee.aventcalendar.model.UserList;

import java.io.IOException;

public interface UserDAO {
    /**
     * get all users
     * @return UserList
     * @throws IOException
     */
    public UserList getUsers(String year) throws IOException;
}
