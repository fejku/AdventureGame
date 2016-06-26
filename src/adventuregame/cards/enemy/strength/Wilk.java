package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Wilk extends EnemyStrenght {

    public Wilk() {
        super("Wilk", 2, EnemyType.ZWIERZE);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Wilk zamieszkał na tym Obszarze. Pozostanie tu, aż ktoś go pokona.");
    }

}
