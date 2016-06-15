package adventuregame.cards.item;

import adventuregame.cards.ACard;

public abstract class Item extends ACard {
	
    private final int amountInDeck;
	private final int costInTown; //??

    public Item(String name, int amountInDeck) {
        super(name, 5, false, true);
        this.amountInDeck = amountInDeck;
        this.costInTown = 0;
    }
    
    public Item(String name, int amountInDeck, int costInTown) {
        super(name, 5, false, true);
        this.amountInDeck = amountInDeck;
    	this.costInTown = costInTown;
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
}
