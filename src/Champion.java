public abstract class Champion {

    private String name;
    private int level;
    private int attackDamage;
    private int defense;
    private int hp;
    private int mp;

    public Champion(String name, int level, int attackDamage, int defense, int hp, int mp) {
        this.name = name;
        this.level = level;
        this.attackDamage = attackDamage;
        this.defense = defense;
        this.hp = hp;
        this.mp = mp;
    }

    public void takeDamage(int damage) {
        int actualDamage = damage - defense;
        if(actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;
        System.out.println(name + "이(가)" + actualDamage + "피해를 입었습니다.");

    }

    // 챔피언이 챔피언을 공격한다
    public void basicAttack(Champion target) {
        System.out.println(getName() + " -> " + target.getName() + "평타 공격!");
        target.takeDamage(attackDamage);
    }

    public void useMp(int amount) {
        if (mp < amount) {
            System.out.println(name + "의 MP가 부족합니다! 스킬을 사용할 수 없습니다.");
            return;
        }
        mp -= amount;
        System.out.println(name + "의 MP가 " + amount + " 감소했습니다. (현재 MP: " + mp + ")");
    }

    // 공통의 QWER 스킬
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);


    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getMp() {
        return mp;
    }
    public int getAttackDamage(){
        return attackDamage;
    }
}
