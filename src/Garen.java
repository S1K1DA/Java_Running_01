public class Garen extends Champion implements MeleeChampion, TankChampion{

    public Garen(String name, int level, int attackDamage, int defense, int hp, int mp) {
        super(name, level, attackDamage, defense, hp, mp);

        setCriticalChance(20);
    }



    @Override
    public void useQ(Champion target) {
        if (!canAct()) return;
        useMp(20);
        System.out.println(getName() + "(Q): 결정타!");
        target.takeDamage(getAttackDamage() + 20);
    }

    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(10);
        System.out.println(getName() + "(W): 용기! 가렌의 방어력이 증가합니다!");
        System.out.println("가렌이 잠시 피해를 덜 받습니다!");
    }

    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(30);
        System.out.println(getName() + "(E): 심판!");
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
    }

    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
        System.out.println(getName() + "(R): 데마시아!!!");
        target.takeDamage(getAttackDamage() + 50);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        UpAttackDamage(5);
        UpHp(30);
        System.out.println("가렌 공격력 5, 체력 30 증가!");
    }

    @Override
    public void meleeAttack() {
        System.out.println(getName() + "이(가) 앞점멸 공격!");
    }

    @Override
    public void upDefense() {
        System.out.println(getName() + "이(가) 방어 자세! 방어력 증가!");
    }
}
