package adventuregame.cards.events;

import java.util.Iterator;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.Field.Region;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class TrzesienieZiemi extends Event {

    public TrzesienieZiemi() {
        super("Trzęsienie ziemi", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Krainą, w której się znajdujesz wstrząsa potężne trzęsienie ziemi. Rzuć kostką dla każdej Karty Przygód, która leży w tej Krainie i jest odkryta. Rezultat równy 1 lub 2 oczkom oznacza, że ta Karta wpada w powstałą w ziemi szczelinę należy ją odłożyć.");
        
        Region region = board.getField(explorers.getActualExplorer().getActualPosition()).getRegion();
        
        for (Field field : board.getFieldsByRegion(region)) {
        	Iterator<ACard> iteratorCard = field.getCards().iterator();
        	while (iteratorCard.hasNext()) {
        		ACard card = iteratorCard.next();
        		if (board.getDice().throwDice() < 3)
        			iteratorCard.remove();
        	}
        }
    }

}
