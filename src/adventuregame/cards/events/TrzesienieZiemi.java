package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class TrzesienieZiemi extends Event {

    public TrzesienieZiemi() {
        super("Trzęsienie ziemi", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
