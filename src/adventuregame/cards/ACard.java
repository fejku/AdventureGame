package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class ACard implements ICard {
    private final String name;
    
    public ACard(String name) {
        this.name = name;
    }
    
    public abstract void Action(Board board, Explorers explorers);  

    public String getName() {
        return name;
    }
    
    
}
