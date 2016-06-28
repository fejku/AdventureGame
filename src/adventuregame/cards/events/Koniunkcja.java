package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Koniunkcja extends Event {

    public Koniunkcja(int startedExplorerNr) {
        super("Koniunkcja", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Gwiazdy ułożyły się w tak szczególny sposób, że na czas jednej tury zostaje podwojona Moc wszystkich Duchów. Potem koniunkcja się kończy odłóż tę Kartę.");
        //Add this card to board.onGoingEvents
        board.getOnGoingEvents().add(this);
    }

}
