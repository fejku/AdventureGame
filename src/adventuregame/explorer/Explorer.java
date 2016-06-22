package adventuregame.explorer;

import java.util.ArrayList;
import java.util.List;

import adventuregame.board.Board;
import adventuregame.board.Board.GameState;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.Field.Region;
import adventuregame.cards.ACard;
import adventuregame.cards.enemy.Enemy;
import adventuregame.cards.item.Item;
import adventuregame.cards.item.weapon.Miecz;
import adventuregame.cards.item.weapon.Topor;
import adventuregame.cards.item.weapon.Weapon;
import adventuregame.cards.spells.Spell;
import adventuregame.utils.Constants;
import adventuregame.utils.IDialog;

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
    private List<Integer> nextMoves;
    
    private List<Item> items;
    private List<Enemy> defeatedCreatures;
    private List<Spell> spells;
    
    private List<Weapon> equippedWeapons;

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
        this.character = character;
        
        actualPosition = startingPosition;
        loseTurn = 0;
        nextMoves = new ArrayList<Integer>();
        
        defeatedCreatures = new ArrayList<>();
        items = new ArrayList<>();
        spells = new ArrayList<>();
        
        equippedWeapons = new ArrayList<>();
        
        test();
    }
public void test() {
items.add(new Miecz());
items.add(new Topor());
//    gainItem(new Miecz());
    gainGold(2);
    actualPosition = 0;
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
    
    public List<Item> getItems() {
        return items;
    }    
    
    public List<Spell> getSpells() {
        return spells;
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
    
    public void loseLife(Board board) {
        loseLife(1, board);
    }
    
    public void loseLife(int lifeAmount, Board board) {
        life -= lifeAmount;
        if (life < 1)
            die(board);
    }
    
    public void die(Board board) {
        board.setGameState(GameState.TURN_END);
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
                "Life: " + life;
        
        for (int i = 0; i < defeatedCreatures.size(); i++) {
            if (i == 0)
                stats += "\nCollected cretures: ";
                stats += "- " + defeatedCreatures.get(i).getName() + " ";
            }
        
        for (int i = 0; i < items.size(); i++) {
            if (i == 0)
                stats += "\nCollected items: ";
                stats += "- " + items.get(i).getName() + " ";
            }
        
        for (int i = 0; i < spells.size(); i++) {
            if (i == 0)
                stats += "\nCollected spells: ";
                stats += "- " + spells.get(i).getName() + " ";
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
    
    public int getStrengthModifiers(boolean withWeapon) {
    	int strengthModifier = 0;
        if (withWeapon)
            for (Weapon weapon: equippedWeapons)
                strengthModifier += weapon.getStrengthModifier();
        return strengthModifier;
    }
    
    public int getStrengthModifiers() {
        return getStrengthModifiers(true);
    }
    
    public int getCraftModifiers() {
        int craftModfier = 0;
//        for (ACardObject item: items)
//        	craftModfier += item.getCraftModfier();
        return craftModfier;
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
    
    public void addNextMove(int fieldNr, int actualExplorerPosition) {
        nextMoves.add(fieldNr);
    }
    
    public void addNextMove(Region region, int actualExplorerPosition) {
    	int bottom = 0, top = 0;
    	
        switch(region) {
            case OUTER:
            	bottom = 0;
            	top = Field.FIELDS_OUTER_QUANTITY_TOP;
                break;
            case MIDDLE:
            	bottom = Field.FIELDS_OUTER_QUANTITY_TOP;
            	top = Field.FIELDS_MIDDLE_QUANTITY_TOP;
                break;
            case INNER:
            	bottom = Field.FIELDS_MIDDLE_QUANTITY_TOP;
            	top = Field.FIELDS_INNER_QUANTITY_TOP;
                break;
        }
        
        for (int i = bottom; i < top; i++) {
            if ((!nextMoves.contains(i)) && (i != actualExplorerPosition)) 
                nextMoves.add(i);
        }
    }
    
    public List<Integer> getNextMoves() {
        return nextMoves;
    }
    
    public int getMissingLife() {
    	int missingLife = Constants.MAX_LIFE - life;
    	if (missingLife < 0)
            return 0;
    	else
            return missingLife;
    }
    
    public int getMaxRegainLife() {
    	int missingLife = getMissingLife();
    	if (gold < missingLife)
            return gold;
    	else
            return missingLife;
    }
    
    public void gainItem(IDialog dialog, Item item) {
    	items.add(item);
    	if (item.isWeapon())
    		setEquippedWeapon(dialog);
    }
    
    public void setEquippedWeapon(IDialog dialog) {
    	List<Weapon> weapons = new ArrayList<>();
        
    	for (Item item: items) 
            if (item.isWeapon())
                weapons.add((Weapon)item);

        String[] weaponsNames = new String[weapons.size()];
        for (int i = 0; i < weapons.size(); i++)
            weaponsNames[i] = weapons.get(i).getName();
		
    	if (weapons.size() == 1) {
            equippedWeapons.clear();
            equippedWeapons.add(weapons.get(0));
        } else {
            if (equippedWeapons.size() > 0) {
                if (dialog.chooseYesNo("Czy zmienić aktualną broń?")) {
                    int choice = dialog.chooseOption("Wybierz aktywną broń.", weaponsNames);
                    equippedWeapons.clear();
                    equippedWeapons.add(weapons.get(choice));
                }
            } else {
                int choice = dialog.chooseOption("Wybierz aktywną broń.", weaponsNames);
                equippedWeapons.add(weapons.get(choice));
            }
    	}
    }
    
    public FightResult fight(List<ACard> enemys) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
