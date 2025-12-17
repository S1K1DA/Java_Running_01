package team;

import champion.Champion;

import java.util.List;

public class TeamUtils {

    public static void printTeamMembers(List<? extends Champion> team) {
        System.out.println("=== 팀 멤버 목록 ===");
        for (Champion c : team) {
            System.out.println("-" + c.getName());
        }
        System.out.println();
    }
}
