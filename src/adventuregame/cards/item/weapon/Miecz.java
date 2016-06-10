package adventuregame.cards.item.weapon;

import adventuregame.board.Board;
import adventuregame.cards.item.AItemsFromTown;
import adventuregame.explorer.Explorers;

public class Miecz extends AItemsFromTown implements IWeapon {
	public Miecz() {
		super("Miecz", 4, 2);
	}

	@Override
	public void Action(Board board, Explorers explorers) {
		explorers.getActualExplorer().gainItem(this);
		
		if (board.getDialog().chooseYesNo("Czy chcesz ustawić jako główną broń?")) {
			//usuń poprzedni 
			//ustaw siłę z przedmiotu
		}
	}
	
	//Nie koniecznie additional
	// +1 do Siły
	public int getAddtionalStats() {
		return 1;
	}
	
}
