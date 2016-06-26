package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Ludojad extends EnemyStrenght {

    public Ludojad() {
        super("Ludojad", 4, EnemyType.POTWOR, 2);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Ludojad zdecydował się, że na tym Obszarze nie zabraknie mu pożywienia. Pozostanie tu, aż ktoś go pokona.");
    }

}
