public class Ash extends Champion implements RangedChampion {

    public Ash(String name) {
        super(
                name,
                1,
                GameConstants.ASHE_AD,
                GameConstants.ASHE_DEF,
                GameConstants.ASHE_HP,
                GameConstants.ASHE_MP
        );

        setCriticalChance(GameConstants.ASHE_CRITICAL);
    }

    @Override
    public void useQ(Champion target) {
        if (!canAct()) return;
        useMp(20);
        upBattleCount();
        System.out.println(getName() + "(Q): 궁사의 집중!");
        target.takeDamage(getAttackDamage() + 20);
    }
    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(30);
        upBattleCount();
        System.out.println(getName() + "(W): 일제 사격!");
        target.takeDamage(getAttackDamage() + 30);
    }
    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(15);
        upBattleCount();
        System.out.println(getName() + "(E): 매 날리기~");
    }
    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        upBattleCount();
        System.out.println(getName() + "(R): 마법의 수정화살!!!");
        target.takeDamage(getAttackDamage() + 50);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        UpAttackDamage(3);
        UpMp(20);
        System.out.println("애쉬 공격력 +3, 마나 20 증가!");
    }

    @Override
    public void rangedAttack() {
        upBattleCount();
        System.out.println(getName() + "이(가) 뒷점멸 공격!");
    }
}
