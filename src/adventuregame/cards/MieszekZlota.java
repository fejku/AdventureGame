package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class MieszekZlota extends Card{

    public MieszekZlota() {
        super("Mieszek złota");
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        explorers.getActualExplorer().addGold(1);
    }
    
}
