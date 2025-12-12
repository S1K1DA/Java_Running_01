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
        this.level = 1;
        this.attackDamage = attackDamage;
        this.defense = defense;
        this.hp = hp;
        this.mp = mp;
    }

    // 배틀 카운트
    private static int battleCount = 0;

    protected static void  upBattleCount() {
        battleCount++;
    }

    // 사망 행동 제한
    protected boolean canAct() {
        if (isDead) {
            System.out.println(name + "은(는) 사망하여 행동할 수 없습니다.");
            return false;
        }
        return true;
    }

    // 부활
    public final void resurrect() {
        if (!isDead) {
            System.out.println(name + "은(는) 아직 살아있어서 부활을 할 수 없습니다.");
            return;
        }

        // 모든 챔피언 부활하면 20%
        int resurrectHp = (int)(getBaseHp() * 0.2);
        int resurrectMp = (int)(getBaseMp() * 0.2);

        this.hp = resurrectHp;
        this.mp = resurrectMp;

        this.isDead = false;

        System.out.println(name + "이(가) 부활했습니다!!");
    }

    // 받은 대미지
    public void takeDamage(int damage) {

        if (isDead) {
            System.out.println(name + "은(는) 이미 사망한 상태입니다!");
            return;
        }

        int actualDamage = damage - defense;
        if(actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;
        System.out.println(name + "이(가) " + actualDamage + "피해를 입었습니다.");

        if (hp <= 0) {
            hp = 0;
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
        upBattleCount();

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

    protected abstract int getBaseHp();
    protected abstract int getBaseMp();

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

    public static int getBattleCount() {
        return battleCount;
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
