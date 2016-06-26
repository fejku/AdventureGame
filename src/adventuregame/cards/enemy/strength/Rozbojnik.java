package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Rozbojnik extends EnemyStrenght {

    public Rozbojnik() {
        super("Rozbójnik", 4, EnemyType.POTWOR, 2);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Groźny rozbójnik zaczął grasować w okolicy. Pozostanie tu, aż ktoś go pokona.");
    }

}
