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
            Log.info(name + "은(는) 사망하여 행동을 못합니다.");
            return false;
        }
        return true;
    }

    // 부활
    public final void resurrect() {
        if (!isDead) {
            Log.info(name + "은(는) 살아있어 부활할 수 없습니다.");
            return;
        }

        if (!canResurrect()) {
            Log.info(name + "은(는) 부활 조건을 만족하지 못합니다.");
            return;
        }

        // 모든 챔피언 부활하면 20%
        int resurrectHp = (int)(getBaseHp() * 0.2);
        int resurrectMp = (int)(getBaseMp() * 0.2);

        this.hp = resurrectHp;
        this.mp = resurrectMp;

        this.isDead = false;

        Log.resurrect(name);
    }

    // 받은 대미지
    public void takeDamage(int damage) {

        if (isDead) {
            Log.info(name + "은(는) 이미 사망한 상태입니다.");
            return;
        }

        int actualDamage = damage - defense;
        if(actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;
        Log.damage(name, actualDamage);

        if (hp <= 0) {
            hp = 0;
            Log.death(name);
            isDead = true; // <- 사망
        } else {
            Log.info(name + " 현재 HP: " + hp);
        }
    }

    public int criticalDamage() {
        int damage = attackDamage;

        if(rand.nextInt(100) < criticalChance) {
            Log.info(name + " 치명타 발생!");
            damage *= 2;
        }
        return damage;
    }

    // 챔피언이 챔피언을 공격한다
    public void basicAttack(Champion target) {

        if (!canAct()) return;
        upBattleCount();

        int damage = criticalDamage();

        Log.skill(name, "기본 공격");
        target.takeDamage(damage);
    }

    public void useMp(int amount) {
        if (mp < amount) {
            Log.info(name + "의 MP가 부족해 스킬을 사용할 수 없습니다!");
            return;
        }
        mp -= amount;
        Log.info(name + "의 MP -" + amount + " (현재 MP: " + mp + ")");
    }

    // 공통의 QWER 스킬
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);

    public abstract boolean canResurrect();

    protected abstract int getBaseHp();
    protected abstract int getBaseMp();

    public void levelUp() {
        level += 1;
        Log.info(name + " 레벨업! 현재 레벨: " + level);
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

    public static class Log {

        public static void info(String message) {
            System.out.println("[INFO] " + message);
        }

        public static void skill(String caster, String skillName) {
            System.out.println("[SKILL] " + caster + " → " + skillName);
        }

        public static void damage(String target, int damage) {
            System.out.println("[DMG] " + target + "이(가) " + damage + " 피해를 받음");
        }

        public static void death(String target) {
            System.out.println("[DEATH] " + target + " 사망!");
        }

        public static void resurrect(String target) {
            System.out.println("[REVIVE] " + target + " 부활!");
        }
    }
}
