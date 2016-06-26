package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Olbrzym extends EnemyStrenght {

    public Olbrzym() {
        super("Olbrzym", 6, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Na tym Obszarze urządził sobie rezydencję okrutny olbrzym. Pozostanie tu, aż ktoś go pokona.");
    }

}
