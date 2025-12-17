package team;

import champion.Champion;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Champion> {

    private String name;
    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    // 팀에 챔피언 추가
    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + "이(가) " + name + " 팀에 추가되었습니다!");
    }

    // 팀 전체 HP 합
    public int getTotalHp() {
        return members.stream()
                .mapToInt(Champion::getHp)
                .sum();
    }

    // 팀 멤버 조회
    public List<T> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }
}
