package adventuregame.cards.enemy.strength;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;
import java.util.Iterator;

/**
 *
 * @author Fake
 */
public class SzalonyWojownik extends EnemyStrenght {

    public SzalonyWojownik() {
        super("Szalony Wojownik", 3, EnemyType.POTWOR, 1, false);
    }

    @Override
    public void writeCardText(IDialog dialog) {
        dialog.message("Najemnego wojownika ogarnął szał bitewny. Pozostanie on na tym Obszarze, aż któs go pokona. Jednak nawet pokonany nie zginie, tylko przeniesie na Obszar odległy od obecnego o wynik rzutu kostką (zgodnie z ruchem wskazówek zegara).");
    }
    
    public void actionAfterLose(Board board, Explorers explorers) {
        super.actionAfterLose(board, explorers);
        int diceResult = board.getDice().throwDice();
        int actualPosition = explorers.getActualExplorer().getActualPosition();
        
        Iterator<ACard> enemyCards = board.getField(actualPosition).getCards().iterator();
        while (enemyCards.hasNext()) {
            ACard enemyCard = enemyCards.next();
            if (enemyCard instanceof SzalonyWojownik) {
                int nextField = board.getNeighbourField(actualPosition, Field.LEFT, diceResult);
                board.getField(nextField).getCards().add(enemyCard);
                enemyCards.remove();
            }
        }
    }
}
