package adventuregame.cards.item;

import adventuregame.cards.ACard;

public abstract class ACardObject extends ACard {
	
    private final int amountInDeck;

    public ACardObject(String name, int amountInDeck) {
        super(name);
        this.amountInDeck = amountInDeck;
    }

    public int getAmountInDeck() {
        return amountInDeck;
    }
}
