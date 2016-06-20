package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Zbojcy extends Event {

	public Zbojcy() {
		super("Zbójcy", false);
	}

	@Override
	public void mainAction(Board board, Explorers explorers) {
		board.getDialog().message("Napada cię banda zbójców i rabuje wszystkie twoje Przedmioty i całe złoto. Ukrywają się swój łup w Oazie (połóż tam Karty Przedmiotów i żetony złota), potem wycofują się do swej kryjówki. Odłóż tę Kartę.");
		
		int goldAmount = explorers.getActualExplorer().getGold();
		explorers.getActualExplorer().setGold(0);
		board.getField(Field.OAZA).setAmountGoldOnField(goldAmount);

		for (int i = 0; i < explorers.getActualExplorer().getItems().size(); i++)
			board.getField(Field.OAZA).putCardOnField(explorers.getActualExplorer().getItems().remove(i));
	}

}
