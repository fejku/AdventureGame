package adventuregame.cards.item;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class MieszekZlota extends ACard{

    public MieszekZlota() {
        super("Mieszek złota");
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        explorers.getActualExplorer().gainGold(1);
    }
    
}
