package creature;

import article.Article;
import article.Gold;

import java.util.ArrayList;

public class Person{
    private int wealth;
    String description;
    int HP;
    int nearDamage;
    int farDamage;
    String attackMethod;
    public Person(){}

    public Person(String description, int HP, int nearDamage, int farDamage, String attackMethod, int wealth) {
        this.wealth = wealth;
        this.description = description;
        this.HP = HP;
        this.nearDamage = nearDamage;
        this.farDamage = farDamage;
        this.attackMethod = attackMethod;
    }

    public int getNearDamage() {
        return nearDamage;
    }

    public void setNearDamage(int nearDamage) {
        this.nearDamage = nearDamage;
    }

    public int getFarDamage() {
        return farDamage;
    }

    public void setFarDamage(int farDamage) {
        this.farDamage = farDamage;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
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


    public String getAttackMethod() {
        return attackMethod;
    }

    public void setAttackMethod(String attackMethod) {
        this.attackMethod = attackMethod;
    }
}
