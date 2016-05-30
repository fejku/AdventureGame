package adventuregame.cards;

import adventuregame.board.Board;
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
        explorers.getActualExplorer().addGold(2);
    }
    
}
