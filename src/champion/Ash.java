package champion;

import champion.roles.RangedChampion;
import config.GameConstants;

public class Ash extends Champion implements RangedChampion {

    private int resurrectCount = 0;
    private static final int MAX_RESURRECT = 2;

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
    protected int getBaseHp() {
        return GameConstants.ASHE_HP;
    }
    @Override
    protected int getBaseMp() {
        return GameConstants.ASHE_MP;
    }

    // 2회 부활 제한
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
        Champion.upBattleCount();
        System.out.println(getName() + "(Q): 궁사의 집중!");
        target.takeDamage(getAttackDamage() + 20);
    }
    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(30);
        Champion.upBattleCount();
        System.out.println(getName() + "(W): 일제 사격!");
        target.takeDamage(getAttackDamage() + 30);
    }
    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(15);
        Champion.upBattleCount();
        System.out.println(getName() + "(E): 매 날리기~");
    }
    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        Champion.upBattleCount();
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
        Champion.upBattleCount();
        System.out.println(getName() + "이(가) 뒷점멸 공격!");
    }
}
