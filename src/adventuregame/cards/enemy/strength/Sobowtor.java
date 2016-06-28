package adventuregame.cards.enemy.strength;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Sobowtor extends EnemyStrenght {

    public Sobowtor() {
        super("Sobowtór", 0, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("(Sobowtór zawsze posiada taką Siłę, z jaką walczy jego przeciwnik.) Na tym Obszarze pojawił sie potwór, zwany sobowtórem. Pozostanie tu, aż ktoś go pokona.");
    }
    
    @Override
    public void actionBeforeFight(Board board, Explorers explorers) {
        super.actionBeforeFight(board, explorers);
        setPower(explorers.getActualExplorer().getStrength());
    }

}
