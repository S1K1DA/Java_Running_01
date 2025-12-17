package team;

import java.util.ArrayList;
import java.util.List;

// 잘못된 설계
public class BadTeam<T> {

    private List<T> members = new ArrayList<>();

    public void add(T member) {
        members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }
}
