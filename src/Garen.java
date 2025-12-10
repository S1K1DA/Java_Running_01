public class Garen extends Champion {

    public Garen(String name, int level, int attackDamage, int defense, int hp, int mp) {
        super(name, level, attackDamage, defense, hp, mp);
    }

    @Override
    public void useQ(Champion target) {
        useMp(20);
        System.out.println(getName() + "(Q): 결정타!");
        target.takeDamage(getAttackDamage() + 20);
    }

    @Override
    public void useW(Champion target) {
        useMp(10);
        System.out.println(getName() + "(W): 용기! 가렌의 방어력이 증가합니다!");
        System.out.println("가렌이 잠시 피해를 덜 받습니다!");
    }

    @Override
    public void useE(Champion target) {
        useMp(30);
        System.out.println(getName() + "(E): 심판!");
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
        target.takeDamage(getAttackDamage() + 10);
    }

    @Override
    public void useR(Champion target) {
        useMp(50);
        System.out.println(getName() + "(R): 데마시아!!!");
        target.takeDamage(getAttackDamage() + 50);
    }
}
