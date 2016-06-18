package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class KsiegaCzarow extends Event {

    public KsiegaCzarow() {
        super("Księga Czarów", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Znalazłeś legendarną Księgę Czarów. Natychmiast uzyskujesz tyle Czarów, na ile pozwala ci twa Moc. Potem Księga znika - odłóż tę Kartę.");
        while (explorers.getActualExplorer().isAnotherSpellAvailable()) {
            explorers.getActualExplorer().gainSpell(board);
        }
    }

}
