package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class MagicznyCyklon extends Event {

    public MagicznyCyklon() {
        super("Magiczny cyklon", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Nad światem przeszedl potężny, magiczny cyklon. Wessał wszystkie Czary wszystkich Poszukiwaczy (niezależnie od tego, gdzie byli), potem rozpłynał się w mgiełkę. Odłoż tę Kartę i wszystkie Karty Czarów, będące w posiadaniu graczy.");
        
        for (Explorer explorer : explorers.getExplorers()) {
            board.getUsedSpells().addAll(explorer.getSpells());
            explorer.getSpells().clear();
        }
    }
}
