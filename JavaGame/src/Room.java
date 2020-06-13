import article.Gemstone;
import article.Gold;
import creature.Boss;
import creature.Creature;
import creature.Monster;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<>();
    private Creature creature;
    private Gold gold;
    private Gemstone gemstone;

    public Room(String description, Boss boss, Gold gold, Gemstone gemstone) {
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public Room(String description, Creature creature, Gold gold) {
        this.description = description;
        this.creature = creature;
        this.gold = gold;
    }

    public Gemstone getGemstone() {
        return gemstone;
    }

    public void setGemstone(Gemstone gemstone) {
        this.gemstone = gemstone;
    }

    public Room(String description, HashMap<String, Room> exits, Creature creature, Gold gold, Gemstone gemstone) {
        this.description = description;
        this.exits = exits;
        this.creature = creature;
        this.gold = gold;
        this.gemstone = gemstone;
    }

    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    public String toString() {
        return description;
    }

    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()) {
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    public Room getExit(String direction) {
        Room ret = null;
        ret = exits.get(direction);
        return ret;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

}
