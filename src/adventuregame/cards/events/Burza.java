package adventuregame.cards.events;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.board.fields.Field.Region;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Burza extends Event {

    public Burza() {
        super("Burza", true);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Nad tą Kariną (tylko Zewnętrzną lub Środkową) rozpętała się gwałtowna burza. Wszyscy Poszukiwacze tracą 1 turę. Potem niebo ropogadza się - odłóż tę Kartę.");
        Region actualRegion = board.getField(explorers.getActualExplorer().getActualPosition()).getRegion();
        if ((actualRegion == Region.OUTER) || (actualRegion == Region.MIDDLE)) {
            for (Explorer explorer : explorers.getExplorers())
                if (board.getField(explorer.getActualPosition()).getRegion() == actualRegion)
                    explorer.loseTurn();
        }
    }
    
    @Override
    public void afterAction(Board board, Explorers explorers) {
        board.setGameState(GameState.TURN_END);
    }
}
