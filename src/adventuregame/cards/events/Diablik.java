package adventuregame.cards.events;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Diablik extends Event {
    
    public Diablik() {
        super("Diablik", true);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Spotkałeś diablika, uwielbiającego teleportować Poszukiwaczy. Rzuć kostką, żeby ustalić gdzie się znajdziesz:" +
                "\n1. Skały\n2. Las\n3. Gospoda\n4. Ruiny\n5. Ukryta Dolina\n6. Przeklęta Polana"); 
        int diceResult = board.getDice().throwDice();
        switch (diceResult) {
            case 1:
                explorers.getActualExplorer().setActualPosition(Field.SKALY);
                break;
            case 2:
                explorers.getActualExplorer().setActualPosition(Field.LAS);
                break;
            case 3:
                explorers.getActualExplorer().setActualPosition(Field.GOSPODA);
                break;
            case 4:
                explorers.getActualExplorer().setActualPosition(Field.RUINY);
                break;
            case 5:
                explorers.getActualExplorer().setActualPosition(Field.UKRYTA_DOLINA);
                break;
            case 6:
                explorers.getActualExplorer().setActualPosition(Field.PRZEKLETA_POLANA);
                break;
        }
    }
    
    @Override
    public void afterAction(Board board, Explorers explorers) {
        board.getDialog().message("Gdy już zniknąłeś, diablik teleportuje siebie - odłoż jego Kartę.");
        board.setGameState(GameState.BEFORE_FIELD_ACTION);
    }
}
