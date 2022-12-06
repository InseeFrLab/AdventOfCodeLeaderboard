package fr.insee.aventcalendar.model.leaderboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserList {
    private Map<String, User> members;

    public Map<String, User> getMembers() {
        return members;
    }

    public void setData(Map<String, User> data) {
        this.members = data;
    }

    /**
     * return member list, sorted by decreasing star number, then decreasing score, then alphabetical order of username
     * @return
     */
    public List<User> getMembersList() {
        ArrayList<User> result = new ArrayList<User>(this.members.values());
        result.sort(Comparator.comparing(User::getStarNumber)     // first comparing by ascending star number
        					  .thenComparing(User::getScore)      // then by ascending score
        					  .reversed()						  // reverse the precedent orders to decreasing star number and descending score
        				      .thenComparing(User::getUsername)); // finally ascending user name
        return result;
    }
}
