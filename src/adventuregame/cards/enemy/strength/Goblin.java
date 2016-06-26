package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Goblin extends EnemyStrenght {

    public Goblin() {
        super("Goblin", 2, EnemyType.POTWOR, 3);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Od pewnego czasu ten Obszar jest pustoszony przez goblina, który pozostanie tu, aż go ktoś pokona.");
    }

}
