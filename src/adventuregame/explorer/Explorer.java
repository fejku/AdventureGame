package adventuregame.explorer;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.cards.enemy.Enemy;
import adventuregame.cards.enemy.Waz;
import adventuregame.cards.object.DwaMieszkiZlota;
import adventuregame.cards.object.MieszekZlota;
import adventuregame.cards.spells.Spell;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fake
 */
public abstract class Explorer {
    private final String name;
    private final int startingPosition;
  
    private int actualPosition;    
    private int gold;
    private final int baseStrength;
    private int strength;
    private final int baseCraft;
    private int craft;
    private int life;
    private ExplorerCharacter character;
  
    private int loseTurn;
    private Set<Integer> nextMoves;
    
    private List<Card> items;
    private List<Enemy> defeatedCreatures;
    private List<Spell> spells;

    public Explorer(String name, int baseStrength, int baseCraft, 
            int startingPosition, ExplorerCharacter character) {
        this.name = name;
        this.startingPosition = startingPosition;
        
        gold = 1;
        life = 4;
        this.baseStrength = baseStrength;
        strength = baseStrength;
        this.baseCraft = baseCraft;
        craft = baseCraft;
        
        actualPosition = startingPosition;
        loseTurn = 0;
        nextMoves = new List<Integer>();
        
        defeatedCreatures = new ArrayList<>();
        items = new ArrayList<>();
        spells = new ArrayList<>();
        test();
    }
public void test() {
    items.add(new Waz());
    items.add(new MieszekZlota());
    items.add(new DwaMieszkiZlota());
}
    //<editor-fold defaultstate="collapsed" desc="Getters and setters">
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public int getStrength() {
        return strength;
    }

    public int getBaseStrength() {
        return baseStrength;
    }
    
    public int getCraft() {
        return craft;
    }
    
    public int getBaseCraft() {
        return baseCraft;
    }
    
    public int getLife() {
        return life;
    }
    
    public ExplorerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(ExplorerCharacter character) {
        this.character = character;
    }
    
    public List<Card> getItems() {
        return items;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Gain">
    public void gainGold() {
        gainGold(1);
    }
    
    public void gainGold(int goldAmount) {
        gold += goldAmount;
    }
    
    public void gainStrength() {
        gainStrength(1);
    }  
    
    public void gainStrength(int amount) {
        strength += amount;
    }
    
    public void gainCraft() {
        gainCraft(1);
    }  
    
    public void gainCraft(int amount) {
        craft += amount;
    }
    
    public void gainLife() {
        gainLife(1);
    }
    
    public void gainLife(int lifeAmount) {
        life += lifeAmount;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Lose">
    public void loseGold() {
        loseGold(1);
    }
    
    public void loseGold(int goldAmount) {
        gold -= goldAmount;
        if (gold < 0)
            gold = 0;
    }
    
    public void loseStrength() {
        loseStrength(1);
    }
    
    public void loseStrength(int amount) {
        if ((strength - amount) >= baseStrength)
            strength -= amount;
    }
    
    public void loseCraft() {
        loseCraft(1);
    }
    
    public void loseCraft(int amount) {
        if ((craft - amount) >= baseCraft)
            craft -= amount;
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
    
    public void loseTurn() {
        loseTurn(1);
    }
    
    public void loseTurn(int turnAmount) {
        loseTurn += turnAmount;
    }    
    //</editor-fold>
    
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
    
    public int getStrengthModifiers() {
        //TODO: zwraca dodatek do siły uzyskany dzięki przedmiotom
        return 0;
    }
    
    public int getCraftModifiers() {
        //TODO: zwraca dodatek do mocy uzyskany dzięki przedmiotom
        return 0;
    }
    
    public FightResult fight(Board board, FightType type, int amount) {
        if (type == FightType.STRENGTH) {
            int myStrength = strength + getStrengthModifiers() + board.getDice().throwDice();
            int foeStrength = amount + board.getDice().throwDice();
            
            if (myStrength > foeStrength)
                return FightResult.WIN;
            else if (myStrength < foeStrength)
                return FightResult.LOSE;
            else
                return FightResult.TIE;
        } else {
            int myCraft = craft + getCraftModifiers() + board.getDice().throwDice();
            int foeCraft = amount + board.getDice().throwDice();
            
            if (myCraft > foeCraft)
                return FightResult.WIN;
            else if (myCraft < foeCraft)
                return FightResult.LOSE;
            else
                return FightResult.TIE;
        }
    }
    
    public void removeItem(int itemNr) {
        items.remove(itemNr);
    }
    
    public void changeIntoToad() {
        
    }
    
    public boolean isAnotherSpellAvailable() {
        if ((craft == 3) && (spells.size() == 0))
            return true;
        else if (((craft > 3) && (craft < 6)) && (spells.size() < 2))
            return true;
        else if ((craft > 5) && (spells.size() < 3))
            return true;
        else
            return false;
    }
    
    /**
     * 
     */
    public void gainSpell(Board board) {
        if (isAnotherSpellAvailable())
            spells.add(board.getSpellFromDeck());
    }
}
