package creature;

public class Creature {
    private String description;
    private int HP;
    private int damage;
    private String attackMethod;

    public Creature() {
    }

    public Creature(String description, int HP, int damage, String attackMethod) {
        this.description = description;
        this.HP = HP;
        this.damage = damage;
        this.attackMethod = attackMethod;
    }

    public Creature(String description, int hp, int damage, String attackMethod, int wealth) {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getAttackMethod() {
        return attackMethod;
    }

    public void setAttackMethod(String attackMethod) {
        this.attackMethod = attackMethod;
    }
}
