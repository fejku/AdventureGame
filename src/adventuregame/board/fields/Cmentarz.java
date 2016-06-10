package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Cmentarz extends Field{
    public Cmentarz() {
        super("Cmentarz");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        Explorer actualExplorer = explorers.getActualExplorer();
        switch(actualExplorer.getCharacter()) {
        case DOBRY:
        	goodAction(board.getDialog(), actualExplorer);
        	break;
        case NEUTRALNY:
        	neutralAction(board.getDialog());
        	break;
        case ZLY:
        	evilAction(board.getDialog(), board.getDice(), actualExplorer);
        	break;
        }
    }
    
    private void goodAction(IDialog dialog, Explorer explorer) {
        dialog.message("Tracisz 1 punkt wytrzymałości.");
        explorer.loseLife();
    }
    
    private void neutralAction(IDialog dialog) {
    	dialog.message("Nic się nie dzieje.");
    }
    
    private void evilAction(IDialog dialog, Dice dice, Explorer explorer) {
        switch(dice.throwDice()) {
        case 1:
            //1. Tracisz 1 turę.
            dialog.message("Tracisz 1 turę.");
            explorer.loseLife();
            break;
        case 2: 
        case 3:
            //2-3. Leczysz 1 punkt Wytrzymałości
            dialog.message("Leczysz 1 punkt Wytrzymałości.");
            explorer.regainLife();
            break;
        case 4:
        case 5:
        case 6:       
            //4-6. Zyskujesz 1 Czar 
            dialog.message("Zyskujesz 1 Czar.");
            //explorers.getActualExplorer().gainSpell(board);
            break;
        }
    }
}
