package adventuregame.cards.object;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class DwaMieszkiZlota extends Card {

    public DwaMieszkiZlota(String name) {
        super("Dwa mieszki złota");
    }
    
    @Override
    public void Action(Board board, Explorers explorers) {
        explorers.getActualExplorer().gainGold(2);
    }
    
}
