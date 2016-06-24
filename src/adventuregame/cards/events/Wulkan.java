package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.Field.Region;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;
import java.util.Iterator;

/**
 *
 * @author Fake
 */
public class Wulkan extends Event {

    public Wulkan() {
        super("Wulkan", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Grzmoty o kłęby dymu oznajmieją o erupcji wulkanu. Wszyscy Nieznajomi, znajdujący się w tej Krainie zostają pochłonięci przez lawę odłoż ich Karty.");
        
        Region actualRegion = board.getField(explorers.getActualExplorer().getActualPosition()).getRegion();
        
        for(Field field : board.getFieldsByRegion(actualRegion))
            for(Iterator<ACard> iterator = field.getCards().iterator(); iterator.hasNext();) {
                ACard card = iterator.next();
                if ((card.getPriority() == 4) && (card.isOnField()))
                    iterator.remove();
            }
                
    }

}
