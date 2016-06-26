package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Lew extends EnemyStrenght {

    public Lew() {
        super("Lew", 3, EnemyType.ZWIERZE);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Lew poluje tu na wszystko i wszystkich. Pozostanie na tym Obszarze, aż ktoś go pokona.");
    }

}
