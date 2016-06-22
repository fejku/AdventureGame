package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightType;

/**
 *
 * @author Fake
 */
public class Skaly extends ActionField {
    public Skaly() {
        super("Skały");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        switch(board.getDice().throwDice()) {
            case 1: 
                //Zaatakował cię Duch (Moc: 4)
                board.getDialog().message("Zaatakował cię Duch (Moc: 4).");
                fightWithoutCard(board, explorers.getActualExplorer(), FightType.CRAFT, 4);
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
                //Wyprowadza cię stąd jaskiniowiec. Zyskujesz 1 punkt Siły
                board.getDialog().message("Wyprowadza cię stąd jaskiniowiec. Zyskujesz 1 punkt Siły.");
                explorers.getActualExplorer().gainStrength();
                break;
            default:
                throw new IndexOutOfBoundsException("Błąd w klasie Skaly w metodzie action. Brak akcji dla uzyskanego wyniku rzutu kostką.");                      
        }
    }
    
    
}
