package adventuregame.cards.item;

public abstract class AItemsFromTown extends ACardObject {

	int costInTown;
	
	public AItemsFromTown(String name, int amountInDeck, int costInTown) {
		super(name, amountInDeck);
		this.costInTown = costInTown;
	}

	public int getCostInTown() {
		return costInTown;
	}
}
