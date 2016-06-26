package adventuregame.cards.enemy.strength;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Waz extends EnemyStrenght {

    public Waz() {
        super("Wąż", 4, EnemyType.ZWIERZE);
    } 

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Ogromny wąż postanowił zamieszkać w tym Obszarze. Pozostanie tu, aż ktoś go pokona.");
    }
}
