import battle.Battle;
import champion.*;
import team.ChampionPool;
import team.Team;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== 프로그램 시작 =====");


        // 챔피언 풀 생성
        ChampionPool pool = new ChampionPool();
        pool.addChampion(new Garen("가렌"));
        pool.addChampion(new Ash("애쉬"));
        pool.addChampion(new Katarina("카타리나"));
        pool.addChampion(new Teemo("티모"));

        // 팀 생성
        Team<Champion> blue = new Team<>("블루");
        Team<Champion> red = new Team<>("레드");

        // 팀 배치
        blue.addMember(pool.get("가렌"));
        blue.addMember(pool.get("카타리나"));

        red.addMember(pool.get("애쉬"));
        red.addMember(pool.get("티모"));

        // 팀 전체 체력 조회
        System.out.println("블루팀 전체 체력: " + blue.getTotalHp());
        System.out.println("레드팀 전체 체력: " + red.getTotalHp());
        System.out.println();


        // 랜덤 전투
        Battle.oneVsOne(blue, red);

        System.out.println();
        System.out.println("===== 프로그램 종료 =====");

    }
}
