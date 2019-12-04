package fr.insee.aventcalendar.controller.api;

import fr.insee.aventcalendar.model.leaderboard.User;
import fr.insee.aventcalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class StandingsController {

    @Autowired
    private UserService userService;

    @GetMapping("/{year}")
    public List<User> apiController (@PathVariable String year) throws IOException {
        List<User> result = userService.getUserList(year);
        return result;
    }
}
