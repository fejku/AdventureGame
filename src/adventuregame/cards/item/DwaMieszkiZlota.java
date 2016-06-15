package adventuregame.cards.item;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class DwaMieszkiZlota extends ACard {

    public DwaMieszkiZlota() {
        super("Dwa mieszki złota", 5, false, false);
    }
    
    @Override
    public void mainAction(Board board, Explorers explorers) {
        explorers.getActualExplorer().gainGold(2);
    }
    
}
