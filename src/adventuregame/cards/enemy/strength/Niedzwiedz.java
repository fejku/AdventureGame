package adventuregame.cards.enemy.strength;

import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Niedzwiedz extends EnemyStrenght {

    public Niedzwiedz() {
        super("Niedzwiedź", 3, EnemyType.POTWOR);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Wściekły niedzwiedź przywędrował tu nie wiadomo skąd. Pozostanie na tym Obszarze, aż ktoś go pokona.");
    }

}
