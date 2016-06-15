package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Diablik extends Event {
    
    public Diablik(String name) {
        super("Diablik", true, false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().chooseOption("Spotkałeś diablika, uwielbiającego teleportować Poszukiwaczy. Rzuć kostką, żeby ustalić gdzie się znajdziesz:", 
                new String[] {"Skały", "Las", "Gospoda", "Ruiny", "Ukryta Dolina", "Przeklęta Polana"});
    }
    
    @Override
    public void afterAction(Board board, Explorers explorers) {
        board.getDialog().message("Gdy ju zniknąłeś, diablik teleportuje siebie - odłoż jego Kartę.");
        
    }
}
