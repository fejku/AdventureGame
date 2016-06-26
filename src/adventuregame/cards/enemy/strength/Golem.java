package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Golem extends EnemyStrenght {

    public Golem() {
        super("Golem", 5, EnemyType.POTWOR, 1, true, true, false, false);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("(Przeciwko golemowi nie można używać Czarów, magicznych Przedmiotów ani broni.) Gigantyczny golem obraca ten Obszar w ruinę. Pozostanie tu, aż ktoś go pokona.");
    }

}
