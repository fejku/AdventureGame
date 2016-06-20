package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Mefistofeles extends Event {

    public Mefistofeles() {
        super("Mefistofeles", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Natknąłeś się na Mefistofelesa, przebywającego z misją w tej Krainie. Jeżeli jesteś Zły, dodaje ci on 1 punkt Mocy, jeżeli jesteś Dobry lub Neutralny zmienia cię w Złego. Potem wraca do swego mrocznego królestwa odłoż jego Kartę.");
        
        if (explorers.getActualExplorer().getCharacter() == ExplorerCharacter.ZLY)
            explorers.getActualExplorer().gainCraft();
        else
            explorers.getActualExplorer().setCharacter(ExplorerCharacter.ZLY);
    }

}
