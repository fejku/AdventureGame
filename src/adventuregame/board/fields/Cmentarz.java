package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;

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
        if (actualExplorer.getCharacter() == ExplorerCharacter.DOBRY) {
            actualExplorer.loseLife();
        } else if (actualExplorer.getCharacter() == ExplorerCharacter.ZLY) {
            switch(board.getDice().throwDice()) {
                case 1:
                    //1. Tracisz 1 turę.
                    board.getDialog().message("Tracisz 1 turę.");
                    actualExplorer.loseLife();
                    break;
                case 2: 
                case 3:
                    //2-3. Leczysz 1 punkt Wytrzymałości
                    board.getDialog().message("Leczysz 1 punkt Wytrzymałości.");
                    actualExplorer.regainLife();
                    break;
                case 4:
                case 5:
                case 6:       
                    //4-6. Zyskujesz 1 Czar 
                    board.getDialog().message("Zyskujesz 1 Czar.");
                    //explorers.getActualExplorer().gainSpell(board);
                    break;
            }
        }
    }
}
