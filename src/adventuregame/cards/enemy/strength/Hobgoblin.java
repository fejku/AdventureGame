package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Hobgoblin extends EnemyStrenght {

    public Hobgoblin() {
        super("Hobgoblin", 3, EnemyType.POTWOR, 2);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Brutalny hogoblin przyczaił się na tym Obszarze. Pozostanie tu, aż ktoś go pokona.");
    }

}
