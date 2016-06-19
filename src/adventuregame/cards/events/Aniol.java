package adventuregame.cards.events;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Aniol extends Event {

    public Aniol() {
        super("Anioł", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Podczas snu odwiedział cię anioł. Jeżeli jesteś Dobry, zyskujesz 1 punkt Wytrzymałości, jeżeli jesteś Zły - tracisz 1 punkt Wytrzymałości. "
                + "Neutralnych anioł ignoruje. Gdy się budzisz, anioła już nie ma - odłóż jego Kartę.");
        switch (explorers.getActualExplorer().getCharacter()) {
            case DOBRY:
                explorers.getActualExplorer().gainLife();
                break;
            case ZLY:
                if (explorers.getActualExplorer().loseLife())
                    board.setGameState(GameState.TURN_END);
                break;
        }
    }

}
