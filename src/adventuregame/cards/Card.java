package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Card {
    private final String name;
    
    public Card(String name) {
        this.name = name;
    }
    
    public abstract void Action(Board board, Explorers explorers);  

    public String getName() {
        return name;
    }
    
    
}
