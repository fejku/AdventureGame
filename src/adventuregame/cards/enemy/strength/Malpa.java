package adventuregame.cards.enemy.strength;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Malpa extends EnemyStrenght {

    public Malpa() {
        super("Małpa", 3, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Krwiożercza małpa sieje strach wśród miejscowej ludności. Pozostanie na tym Obszarze, aż ktoś ją pokona.");
    }
}
