package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Cmentarz extends ActionField {
    public Cmentarz() {
        super("Cmentarz");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        Explorer actualExplorer = explorers.getActualExplorer();
        switch(actualExplorer.getCharacter()) {
        case DOBRY:
            goodAction(board, actualExplorer);
            break;
        case NEUTRALNY:
            neutralAction(board.getDialog());
            break;
        case ZLY:
            evilAction(board, actualExplorer);
            break;
        }
    }
    
    private void goodAction(Board board, Explorer explorer) {
        board.getDialog().message("Tracisz 1 punkt wytrzymałości.");
        explorer.loseLife(board);
    }
    
    private void neutralAction(IDialog dialog) {
    	dialog.message("Nic się nie dzieje.");
    }
    
    private void evilAction(Board board, Explorer explorer) {
        switch(board.getDice().throwDice()) {
        case 1:
            //1. Tracisz 1 turę.
            board.getDialog().message("Tracisz 1 turę.");
            explorer.loseLife(board);
            break;
        case 2: 
        case 3:
            //2-3. Leczysz 1 punkt Wytrzymałości
            board.getDialog().message("Leczysz 1 punkt Wytrzymałości.");
            explorer.regainLife();
            break;
        case 4:
        case 5:
        case 6:       
            //4-6. Zyskujesz 1 Czar 
            board.getDialog().message("Zyskujesz 1 Czar.");
            //explorers.getActualExplorer().gainSpell(board);
            break;
        default:
            throw new IndexOutOfBoundsException("Błąd w klasie Cmentarz w metodzie evilAction. Brak akcji dla uzyskanego wyniku rzutu kostką.");                            
        }
    }
}
