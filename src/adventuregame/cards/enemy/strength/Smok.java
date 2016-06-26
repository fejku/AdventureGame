package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Smok extends EnemyStrenght {

    public Smok() {
        super("Smok", 7, EnemyType.SMOK, 3);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Od pewnego czasu tę okolicę terroryzuje smok, który pozostanie tu, aż ktoś go pokona.");
    }

}
