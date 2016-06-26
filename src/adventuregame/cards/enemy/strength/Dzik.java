package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Dzik extends EnemyStrenght {

    public Dzik() {
        super("Dzik", 1, EnemyType.POTWOR, 2);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Ogromny dzik włóczy się po tej okolicy. Pozostanie tu, aż ktoś go pokona.");
    }

}
