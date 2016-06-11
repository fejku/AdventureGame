package adventuregame.cards.spells;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Spell {

    public final String name;
    
    public Spell(String name) {
        this.name = name;
    }

    public void Action(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }
    
}
