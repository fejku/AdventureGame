package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class ACard implements ICard {
    
    private final String name;
    private final int priority;
    
    public ACard(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    public abstract void Action(Board board, Explorers explorers);  

    public String getName() {
        return name;
    }
    
    public int getPriority() {
        return priority;
    }
}
