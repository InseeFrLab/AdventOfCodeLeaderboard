package fr.insee.aventcalendar.service;

import fr.insee.aventcalendar.dao.UserDAO;
import fr.insee.aventcalendar.model.leaderboard.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUserList(String year) throws IOException {
        return userDAO.getUsers(year).getMembersList();
    }
}
