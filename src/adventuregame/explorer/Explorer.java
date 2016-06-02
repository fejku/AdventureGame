package adventuregame.explorer;

import adventuregame.cards.enemy.Enemy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public abstract class Explorer {
    private final String name;
    private final int startingPosition;
  
    private int actualPosition;    
    private int gold;
    private int strength;
    private int life;
    private ExplorerCharacter character;
  
    private int loseTurn;
    
    private List<Enemy> defeatedCreatures;

    public Explorer(String name, int strength, int startingPosition, ExplorerCharacter character) {
        this.name = name;
        this.startingPosition = startingPosition;
        
        gold = 1;
        life = 4;
        this.strength = strength;
        
        actualPosition = startingPosition;
        loseTurn = 0;
        
        defeatedCreatures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public int getStartingPosition() {
        return startingPosition;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }
    
    public void gainGold(int goldAmount) {
        gold += goldAmount;
    }
    
    public void loseGold(int goldAmount) {
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
    
    public void gainLife() {
        gainLife(1);
    }
    
    public void gainLife(int lifeAmount) {
        life += lifeAmount;
    }
    
    /**
     * Poszukiwacz odzyskuje 1 punkt Wytrzymałości
     * @return True jeżeli Poszukiwacz odzykał życie. 
     * False gdy Poszukiwacz miał 4 punkty Wytrzymałości.
     */
    public boolean regainLife() {
        return regainLife(1);
    }
    
    public boolean regainLife(int lifeAmount) {
        int tempLife = life + lifeAmount;
        if (tempLife > 4)
            return false;
        else {
            life = tempLife;
            return true;
        }        
    }
    
    public boolean loseLife() {
        return loseLife(1);
    }
    
    public boolean loseLife(int lifeAmount) {
        life -= lifeAmount;
        if (life>0)
            return false;
        else
            return true;
    }
    
    public void addCreature(Enemy creature) {
        defeatedCreatures.add(creature);
    }

    public ExplorerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(ExplorerCharacter character) {
        this.character = character;
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
    
    public void loseTurn() {
        loseTurn(1);
    }
    
    public void loseTurn(int turnAmount) {
        loseTurn += turnAmount;
    }
    
    public void passLoseTurn() {
        if (isLosesTurn()) {
            loseTurn--;
        }
    }
    
    public boolean isLosesTurn() {
        if (loseTurn > 0)
            return true;
        else
            return false;
    }
}
