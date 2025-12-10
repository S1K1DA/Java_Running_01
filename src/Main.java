public class Main {
    public static void main(String[] args) {

        Champion garen = new Garen("가렌", 1, 35, 10, 250, 50);
        Champion ash = new Ash("애쉬", 1, 20, 5, 200, 70);

        System.out.println("===== 1차 라인전 시작! =====");

        // 1. 평타 교환
        System.out.println("기본 공격 교환!");
        garen.basicAttack(ash);
        ash.basicAttack(garen);

        System.out.println("===== 스킬 사용 =====");

        // 2. 스킬 교환
        System.out.println("[2턴] 스킬 난타전!");
        garen.useQ(ash);
        ash.useW(garen);

        System.out.println();

        garen.useE(ash);
        ash.useR(garen);

        System.out.println("===== 전투 종료 =====");
        System.out.println("가렌 남은 체력: " + garen.getHp());
        System.out.println("애쉬 남은 체력: " + ash.getHp());

        ash.useE(garen);
        ash.basicAttack(garen);
    }
}
