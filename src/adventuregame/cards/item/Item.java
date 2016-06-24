package adventuregame.cards.item;

import adventuregame.cards.ACard;

public abstract class Item extends ACard {
	
    private final int amountInDeck;
    private final int costInTown; //??
    private final int strengthModifier;
   
    public Item(String name, int amountInDeck, int strengthModifier, int costInTown) {
        super(name, 5, false, true);
        this.amountInDeck = amountInDeck;
        this.costInTown = costInTown;
        this.strengthModifier = strengthModifier;        
    }
    
    public Item(String name, int amountInDeck, int strengthModifier) {
        this(name, amountInDeck, strengthModifier, 0);
    }    

    public int getAmountInDeck() {
        return amountInDeck;
    }
    
    public int getCostInTown() {
    	return costInTown;
    }
    
    public boolean isWeapon() {
    	return false;
    }
    
    public int getStrengthModifier() {
        return strengthModifier;
    }
}
