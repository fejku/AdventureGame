package adventuregame.cards.item.weapon;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

public class Miecz extends Weapon {
	
    public Miecz() {
        super("Miecz", 4, 2, WeaponType.ONE_HANDED, 1);
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        explorers.getActualExplorer().gainItem(this);

        if (board.getDialog().chooseYesNo("Czy chcesz ustawić jako główną broń?")) {
            //usuń poprzedni 
            //ustaw siłę z przedmiotu
        }
    }
}
