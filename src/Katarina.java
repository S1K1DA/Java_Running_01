public class Katarina extends Champion implements MeleeChampion{

    public Katarina(String name) {
        super(
                name,
                1,
                GameConstants.KATARINA_AD,
                GameConstants.KATARINA_DEF,
                GameConstants.KATARINA_HP,
                GameConstants.KATARINA_MP
        );

        setCriticalChance(GameConstants.KATARINA_CRITICAL);
    }

    @Override
    public void useQ(Champion target) {
        if (!canAct()) return;
        useMp(20);
        upBattleCount();
        System.out.println(getName() + "(Q): 단검 투척!");
        target.takeDamage(getAttackDamage() + 20);
    }

    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(10);
        upBattleCount();
        System.out.println(getName() + "(W): 용기! 카타리나의 이동속도가 증가합니다!");
    }

    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(30);
        upBattleCount();
        System.out.println(getName() + "(E): 순보!");
        target.takeDamage(getAttackDamage() + 5);
    }

    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        upBattleCount();
        System.out.println(getName() + "(R): 죽음의 연꽃!!!");
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        UpAttackDamage(5);
        UpHp(20);
        System.out.println("카타리나 공격력 5, 체력 20 증가!");
    }

    @Override
    public void meleeAttack() {
        upBattleCount();
        System.out.println(getName() + "이(가) 앞점멸 공격!");
    }
}
