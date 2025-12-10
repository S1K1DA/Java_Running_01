public class Ash extends Champion {

    public Ash(String name, int level, int attackDamage, int defense, int hp, int mp) {
        super(name, level, attackDamage, defense, hp, mp);
    }

    @Override
    public void useQ(Champion target) {
        useMp(20);
        System.out.println(getName() + "(Q): 궁사의 집중!");
        target.takeDamage(getAttackDamage() + 20);
    }
    @Override
    public void useW(Champion target) {
        useMp(30);
        System.out.println(getName() + "(W): 일제 사격!");
        target.takeDamage(getAttackDamage() + 30);
    }
    @Override
    public void useE(Champion target) {
        useMp(15);
        System.out.println(getName() + "(E): 매 날리기~");
    }
    @Override
    public void useR(Champion target) {
        useMp(50);
        System.out.println(getName() + "(R): 마법의 수정화살!!!");
        target.takeDamage(getAttackDamage() + 50);
    }

}
