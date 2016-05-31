package adventuregame.explorer;

import adventuregame.cards.creature.Creature;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public abstract class Explorer {
    private String name;
    private int startingPosition;
    private int actualPosition;
    
    private int gold;
    private int strength;
    private int life;
    
    private List<Creature> defeatedCreatures;

    public Explorer(int strength) {
        gold = 0;
        life = 4;
        this.strength = strength;
        
        defeatedCreatures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
        actualPosition = startingPosition;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }
    
    public void addGold(int goldAmount) {
        gold += goldAmount;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public int getLife() {
        return life;
    }
    
    public void addLife() {
        life++;
    }
    
    public boolean subtractLife() {
        life--;
        if (life>0)
            return false;
        else
            return true;
    }
    
    public void addCreature(Creature creature) {
        defeatedCreatures.add(creature);
    }
    
    public String writeStats() {
    	String stats;
        stats = "Name: " + name + "\n" +
                "Starting position: " + startingPosition + "\n" +
                "Actual position: " + actualPosition + "\n" +
                "Gold: " + gold + "\n" +
                "Strength: " + strength + "\n" +
                "Life: " + life + "\n" +
                "Collected cretures: ";
        for (int i = 0; i < defeatedCreatures.size(); i++) {
			stats += "\n\t- " + defeatedCreatures.get(i).getName();
		}
        return stats;
    }
}
