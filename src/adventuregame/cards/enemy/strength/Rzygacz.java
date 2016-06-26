package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Rzygacz extends EnemyStrenght {

    public Rzygacz() {
        super("Rzygacz", 5, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Ohydny rzygacz sieje spustoszenie w tej okolicy. Pozostanie tu, aż ktoś go pokona.");
    }

}
