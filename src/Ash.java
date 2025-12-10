public class Ash extends Champion {

    public Ash(String name, int level, int attackDamage, int defense, int hp, int mp) {
        super(name, level, attackDamage, defense, hp, mp);
    }

    @Override
    public void useQ(Champion target) {
        if (!canAct()) return;
        useMp(20);
        System.out.println(getName() + "(Q): 궁사의 집중!");
        target.takeDamage(getAttackDamage() + 20);
    }
    @Override
    public void useW(Champion target) {
        if (!canAct()) return;
        useMp(30);
        System.out.println(getName() + "(W): 일제 사격!");
        target.takeDamage(getAttackDamage() + 30);
    }
    @Override
    public void useE(Champion target) {
        if (!canAct()) return;
        useMp(15);
        System.out.println(getName() + "(E): 매 날리기~");
    }
    @Override
    public void useR(Champion target) {
        if (!canAct()) return;
        useMp(50);
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

}
