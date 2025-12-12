public class Main {
    public static void main(String[] args) {

        Champion garen = new Garen("가렌");
        Champion ashe = new Ash("애쉬");

        System.out.println("===== 1차 라인전 시작! =====\n");

        // 1. 평타 교환
        System.out.println("=== 기본 공격 교환 ===");
        garen.basicAttack(ashe);
        ashe.basicAttack(garen);

        System.out.println();

        // 2. 스킬 교환
        System.out.println("===== 스킬 난타전! =====");

        garen.useQ(ashe);
        ashe.useW(garen);

        garen.useE(ashe);
        ashe.useR(garen);

        System.out.println();

        // 3. 사망 테스트
        System.out.println("===== 마무리 일격! =====");

        // 가렌이 애쉬에게 여러 번 공격하여 강제로 죽여보자
        while (ashe.getHp() > 0) {
            garen.basicAttack(ashe);
        }

        System.out.println();

        // 4. 부활 테스트
        System.out.println("===== 부활 시도 =====");
        ashe.resurrect();

        System.out.println();

        // 5. 부활 이후 다시 행동 가능?
        ashe.basicAttack(garen);
        System.out.println();

        // 6. 전투 횟수 출력
        System.out.println("===== 전투 종료 =====");
        System.out.println("총 전투 횟수(battleCount): " + Champion.getBattleCount());

        // 가렌 부활 테스트
        garen.takeDamage(9999);
        System.out.println("가렌 현재 HP: " + garen.getHp());
        // 가렌 부활후 또죽이기!
        garen.resurrect();
        garen.takeDamage(9999);
        garen.resurrect();

        // 애쉬 부활 테스트
        ashe.takeDamage(9999);
        System.out.println("애쉬 현재 HP: " + ashe.getHp());

        ashe.resurrect();
        ashe.takeDamage(9999);
        ashe.resurrect();
    }
}
