package fr.insee.aventcalendar.model.calendar;

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
     * return member list, sorted by score
     * @return
     */
    public List<User> getMembersList() {
        ArrayList<User> result = new ArrayList<User>(this.members.values());
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return t1.getScore() - user.getScore();
            }
        });
        return result;
    }
}
