import java.util.Random;

public abstract class Champion {

    private String name;
    private int level;
    private int attackDamage;
    private int defense;
    private int hp;
    private int mp;

    // 기본 치명타 확률
    private int criticalChance = 10;

    private boolean isDead = false;
    private Random rand = new Random();

    public Champion(String name, int level, int attackDamage, int defense, int hp, int mp) {
        this.name = name;
        this.level = level;
        this.attackDamage = attackDamage;
        this.defense = defense;
        this.hp = hp;
        this.mp = mp;
    }

    protected boolean canAct() {
        if (isDead) {
            System.out.println(name + "은(는) 사망하여 행동할 수 없습니다.");
            return false;
        }
        return true;
    }

    // 받은 대미지
    public void takeDamage(int damage) {
        int actualDamage = damage - defense;
        if(actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;
        System.out.println(name + "이(가) " + actualDamage + "피해를 입었습니다.");

        if (hp <= 0) {
            System.out.println(name + " 사망!");
            isDead = true; // <- 사망
        } else {
            System.out.println("hp가 " + hp + "남았습니다.");
        }
    }

    public int criticalDamage() {
        int damage = attackDamage;

        if(rand.nextInt(100) < criticalChance) {
            System.out.println("치명타가 발생했습니다!!");
            damage *= 2;
        }
        return damage;
    }

    // 챔피언이 챔피언을 공격한다
    public void basicAttack(Champion target) {

        if (!canAct()) return;

        int damage = criticalDamage();

        System.out.println(getName() + " -> " + target.getName() + "평타 공격!");
        target.takeDamage(damage);
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

    public void levelUp() {
        level += 1;
        System.out.println(name + "이(가) 레벨업! 현재 레벨: " + level);
    }


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


    public void UpAttackDamage(int amount) {
        this.attackDamage += amount;
    }
    public void UpHp(int amount) {
        this.hp += amount;
    }
    public void UpMp(int amount) {
        this.mp += amount;
    }
    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }
}
