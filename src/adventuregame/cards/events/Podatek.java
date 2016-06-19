package adventuregame.cards.events;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.board.fields.Field.Region;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Podatek extends Event{

    public Podatek() {
        super("Podatek", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Został nałożony podatek w wysokości 1 mieszka złota. Rzuć kością, żeby ustalić na kogo:\n1. na Dobrych\n2. na Złych\n3. na Neutralnych\n4. na mających złoto\n5. na tych w Zewnętrznej Krainie\n6. na tych w Środkowej Krainie. Nie posiadający złota są chłostani - tracą 1 punkt Wytrzymałości. Po ściągnięciu podatku Karta jest odkładana.");
        List<Explorer> taxedExplorers = new ArrayList<>();
        switch(board.getDice().throwDice()) {
            case 1:
                taxedExplorers = explorers.getExplorersByCharacter(ExplorerCharacter.DOBRY, true);
                break;
            case 2:
                taxedExplorers = explorers.getExplorersByCharacter(ExplorerCharacter.ZLY, true);
                break;
            case 3:
                taxedExplorers = explorers.getExplorersByCharacter(ExplorerCharacter.NEUTRALNY, true);
                break;
            case 4:
                taxedExplorers = explorers.getExplorersHavingGold(true);
                break;
            case 5:
                taxedExplorers = explorers.getExplorersFromRegion(Region.OUTER, board, true);
                break;
            case 6:
                taxedExplorers = explorers.getExplorersFromRegion(Region.MIDDLE, board, true);
                break;
        }
        
        for (Explorer explorer : taxedExplorers) {
            if (explorer.getGold() > 0)
                explorer.loseGold();
            else {
                if (explorer.loseLife())
                    board.setGameState(GameState.TURN_END);
            }
        }
    }

}
