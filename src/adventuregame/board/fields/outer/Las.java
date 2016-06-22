package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightType;

/**
 *
 * @author Fake
 */
public class Las extends ActionField {

    public Las() {
        super("Las");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        switch(board.getDice().throwDice()) {
            case 1: 
                //Zaatakował cię bandyta (Siła: 4)
                board.getDialog().message("Zaatakował cię bandyta (Siła: 4).");
                fightWithoutCard(board, explorers.getActualExplorer(), FightType.STRENGTH, 4);
                break;
            case 2:
            case 3:
                //Tracisz następną turę
                board.getDialog().message("Tracisz następną turę.");
                explorers.getActualExplorer().loseTurn();
                break;
            case 4:
            case 5:
                //Nic się nie dzieje
                board.getDialog().message("Nic się nie dzieje.");
                break;
            case 6:
                //Wyprowadza cię stąd leśniczy. Zyskujesz 1 punkt Mocy
                board.getDialog().message("Wyprowadza cię stąd leśniczy. Zyskujesz 1 punkt Mocy.");
                explorers.getActualExplorer().gainCraft();
                break;
            default:
                throw new IndexOutOfBoundsException("Błąd w klasie Las w metodzie action. Brak akcji dla uzyskanego wyniku rzutu kostką.");                    
        }
    }
    
    
}
