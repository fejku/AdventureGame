package adventuregame.cards.enemy.strength;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Jeszczur extends EnemyStrenght {

    public Jeszczur() {
        super("Jaszczur", 3, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("W okolicy przyczaił się ogromny jaszczur. Pozostanie tu, aż ktoś go pokona.");
    }
}
