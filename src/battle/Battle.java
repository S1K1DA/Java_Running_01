package battle;

import champion.Champion;
import team.Team;

import java.util.List;
import java.util.Random;

public class Battle {

    private static final Random random = new Random();

    // 1:1 랜덤 전투
    public static void oneVsOne(Team<? extends Champion> t1, Team<? extends Champion> t2) {

        Champion c1 = randomPick(t1.getMembers());
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("===== 1:1 전투 시작 =====");
        System.out.println(c1.getName() + " vs " + c2.getName());
        System.out.println("=========================");

        // 기본 공격 교환
        c1.basicAttack(c2);
        c2.basicAttack(c1);

        // Q 스킬 교환
        c1.useQ(c2);
        c2.useQ(c1);

        System.out.println("===== 전투 종료 =====");
    }


    // 랜덤 챔피언 선택
    private static Champion randomPick(List<? extends Champion> list) {
        return list.get(random.nextInt(list.size()));
    }
}
