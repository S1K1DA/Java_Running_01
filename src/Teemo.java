public class Teemo extends Champion implements RangedChampion {

    private int resurrectCount = 0;
    private static final int MAX_RESURRECT = 2;

    public Teemo(String name) {
        super(
                name,
                1,
                GameConstants.TEEMO_AD,
                GameConstants.TEEMO_DEF,
                GameConstants.TEEMO_HP,
                GameConstants.TEEMO_MP
        );

        setCriticalChance(GameConstants.TEEMO_CRITICAL);
    }

    @Override
    protected int getBaseHp() {
        return GameConstants.TEEMO_HP;
    }
    @Override
    protected int getBaseMp() {
        return GameConstants.TEEMO_MP;
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
        upBattleCount();
        System.out.println(getName() + "(Q): 실명 다트!!");
        target.takeDamage(getAttackDamage() + 15);
        System.out.println(target.getName() + "이(가) 잠시 실명 상태가 됩니다!");
    }

    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(15);
        upBattleCount();
        System.out.println(getName() + "(W): 신속한 이동!");
        System.out.println(getName() + "의 이동 속도가 잠시 증가합니다!");
    }

    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(25);
        upBattleCount();
        System.out.println(getName() + "(E): 독침!");
        target.takeDamage(getAttackDamage() + 10);

        // 독 데미지 2틱 더
        System.out.println("독 데미지가 추가로 들어갑니다!");
        target.takeDamage(5);
        target.takeDamage(5);
    }

    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        upBattleCount();
        System.out.println(getName() + "(R): 유독성 함정!!!");
        target.takeDamage(getAttackDamage() + 20);
        target.takeDamage(getAttackDamage() + 20);
        target.takeDamage(getAttackDamage() + 20);
        System.out.println("버섯이 폭발하며 지속 피해를 입습니다!");
    }

    @Override
    public void levelUp() {
        super.levelUp();
        UpAttackDamage(3);
        UpHp(20);
        System.out.println("티모 공격력 +3, 체력 +20 증가!");
    }

    @Override
    public void rangedAttack() {
        upBattleCount();
        System.out.println(getName() + "이(가) 멀리서 빠르게 화살을 발사합니다!");
    }
}
