package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class MagicznyCyklon extends Event {

    public MagicznyCyklon() {
        super("Magiczny cyklon", false, false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Nad światem przeszedl potężny, magiczny cyklon. Wessał wszystkie Czary wszystkich Poszukiwaczy (niezależnie od tego, gdzie byli), potem rozpłynał się w mgiełkę. Odłoż tę Kartę i wszystkie Karty Czarów, będące w posiadaniu graczy.");
        
        for (Explorer explorer : explorers.getExplorers()) {
            board.getUsedSpells().addAll(explorer.getSpells());
            explorer.getSpells().clear();
        }
    }
    
    @Override
    public void afterAction(Board board, Explorers explorers) {
//        int actualPosition = explorers.getActualExplorer().getActualPosition();
//        Field actualField = board.getField(actualPosition);
//        
//        if (actualField.getCards().remove(this))
//            board.getUsedAdventureCards().add(this);
    }    
}
