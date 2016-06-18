package adventuregame.board.fields.outer.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;

public class Mystic extends ACitizen {

    public Mystic() {
        super("Mystic");
    }

    //MYSTIC: Roll 1 die
    //1-3. Ignored
    //4. If you are Evil or Neutral, you become Good
    //5. Gain 1 Craft
    //6. Gain 1 Spell
    @Override
    public void action(Board board, Explorer explorer) {
        switch (board.getDice().throwDice()) {
        case 1:
        case 2:
        case 3:
            board.getDialog().message("Zostałeś zignorowany.");
            break;
        case 4:
            board.getDialog().message("Jeżeli jesteś Zły lub Neutralny to stajesz się Dobry.");
            if (explorer.getCharacter() != ExplorerCharacter.DOBRY)
                explorer.setCharacter(ExplorerCharacter.DOBRY);
            break;
        case 5:
            board.getDialog().message("Otrzymujesz 1 punkt Mocy.");
            explorer.gainCraft();
            break;
        case 6:
            board.getDialog().message("Otrzymujesz 1 Zaklęcie.");
            //explorer.gainSpell(board);
            break;
        default:
            throw new IndexOutOfBoundsException("Błąd w klasie Mystic w metodzie action. Brak akcji dla uzyskanego wyniku rzutu kostką.");
        }

    }

}
