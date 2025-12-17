import battle.Battle;
import champion.*;
import team.BadTeam;
import team.ChampionPool;
import team.Team;
import team.TeamUtils;

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


        System.out.println("===== TeamUtils 출력 테스트 =====");
        TeamUtils.printTeamMembers(blue.getMembers());
        TeamUtils.printTeamMembers(red.getMembers());

        System.out.println("===== BadTeam 설계 예시 =====");


        BadTeam<Object> badTeam = new BadTeam<>();

        // 1. 정상 팀이라면 Champion만 들어가야함
        badTeam.add(new Garen("가렌"));
        badTeam.add("문자열");
        badTeam.add(12345);

        System.out.println("BadTeam 멤버 추가 완료.");

        // 2️. 잘못된 팀으로 전투 시도 (시도 자체가 불가능함)
        System.out.println("=== BadTeam 전투 시도 ===");
        Object random1 = badTeam.getMembers().get(0);
        Object random2 = badTeam.getMembers().get(1);

        System.out.println("선택된 멤버1 타입: " + random1.getClass().getSimpleName());
        System.out.println("선택된 멤버2 타입: " + random2.getClass().getSimpleName());

        try {
            Champion c1 = (Champion) random1;
            Champion c2 = (Champion) random2;

            c1.basicAttack(c2);

        } catch (Exception e) {
            System.out.println("전투 불가! BadTeam 챔피언 말고 잘못된 정보가 들어가있습니다.");
            System.out.println("에러 타입: " + e.getClass().getSimpleName());
            System.out.println("메시지: " + e.getMessage());
        }

        System.out.println("===== BadTeam 예시 종료=====");



        System.out.println();
        System.out.println("===== 프로그램 종료 =====");

    }
}
