package adventuregame.cards.item.weapon;

import adventuregame.board.Board;
import adventuregame.cards.item.Item;
import adventuregame.explorer.Explorers;

public abstract class Weapon extends Item {

    public enum WeaponType {ONE_HANDED, TWO_HANDED};

    private final int strengthModifier;
    private final WeaponType weaponType; 

    public Weapon(String name, int amountInDeck, int strengthModifier, WeaponType weaponType) {
        super(name, amountInDeck);
        this.strengthModifier = strengthModifier;
        this.weaponType = weaponType;
    }

    public Weapon(String name, int amountInDeck, int strengthModifier, WeaponType weaponType, int costInTown) {
        super(name, amountInDeck, costInTown);
        this.strengthModifier = strengthModifier;
        this.weaponType = weaponType;
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        explorers.getActualExplorer().gainItem(board.getDialog(), this);
    }
    
    public int getStrengthModifier() {
    	return strengthModifier;
    }
    
    public WeaponType getWeaponType() {
    	return weaponType;
    }
    
    @Override
    public boolean isWeapon() {
    	return true;
    }
}
