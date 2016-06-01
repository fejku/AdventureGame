package adventuregame.explorer;

import adventuregame.cards.enemy.Enemy;
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
    
    private int lostTurn;
    
    private int gold;
    private int strength;
    private int life;
    
    private List<Enemy> defeatedCreatures;

    public Explorer(int strength) {
        lostTurn = 0;
        
        gold = 1;
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
    
    public void subGold(int goldAmount) {
        gold -= goldAmount;
        if (gold < 0)
            gold = 0;
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
        addLife(1);
    }
    
    public void addLife(int lifeAmount) {
        life += lifeAmount;
    }
    
    public boolean renewLife(int lifeAmount) {
        int tempLife = life + lifeAmount;
        if (tempLife > 4)
            return false;
        else {
            life = tempLife;
            return true;
        }
        
    }
    
    public boolean subtractLife() {
        return subtractLife(1);
    }
    
    public boolean subtractLife(int lifeAmount) {
        life -= lifeAmount;
        if (life>0)
            return false;
        else
            return true;
    }
    
    public void addCreature(Enemy creature) {
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
    
    public void addLostTurn(int amount) {
        lostTurn += amount;
    }
    
    public void subLostTurn() {
        lostTurn--;
    }
    
    public boolean isLosesTurn() {
        if (lostTurn > 0)
            return true;
        else
            return false;
    }
}
