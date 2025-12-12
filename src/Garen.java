public class Garen extends Champion implements MeleeChampion, TankChampion{

    private int resurrectCount = 0;
    private static final int MAX_RESURRECT = 1;

    public Garen(String name) {
        super(
                name,
                1,
                GameConstants.GAREN_AD,
                GameConstants.GAREN_DEF,
                GameConstants.GAREN_HP,
                GameConstants.GAREN_MP
        );

        setCriticalChance(GameConstants.GAREN_CRITICAL);
    }

    @Override
    protected int getBaseHp() {
        return GameConstants.GAREN_HP;
    }
    @Override
    protected int getBaseMp() {
        return GameConstants.GAREN_MP;
    }

    // 1회 부활 제한
    @Override
    public boolean canResurrect() {
        if (resurrectCount >= MAX_RESURRECT) {
            return false;
        }
        resurrectCount++;
        return true;
    }

    @Override
    public void useQ(Champion target) {
        if (!canAct()) return;
        useMp(20);
        upBattleCount();
        Log.skill(getName(), "Q - 결정타!");
        target.takeDamage(getAttackDamage() + 20);
    }

    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(10);
        upBattleCount();
        Log.skill(getName(), "(W): 용기! 가렌의 방어력이 증가합니다!");
        Log.info("가렌이 잠시 피해를 덜 받습니다!");

    }

    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(30);
        upBattleCount();
        Log.skill(getName(), "(E): 심판!");
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
    }

    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        upBattleCount();
        Log.skill(getName(), "(R): 데마시아!!");
        target.takeDamage(getAttackDamage() + 50);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        UpAttackDamage(5);
        UpHp(30);
        Log.info("가렌의 공격력 5 , 체력 30 증가!");
    }

    @Override
    public void meleeAttack() {
        upBattleCount();
        Log.skill(getName(), ": 앞점멸 평타!!!");
    }

    @Override
    public void upDefense() {
        upBattleCount();
        Log.skill(getName(), "이(가) 방어 자세! 방어력 증가!");
    }
}
