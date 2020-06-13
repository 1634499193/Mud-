package creature;

import creature.Monster;

public class Boss extends Monster {
    public Boss() {
    }

    public Boss(String description, int HP, int damage, String attackMethod) {
        super(description, HP, damage, attackMethod);
    }
}
