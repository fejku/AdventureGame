package adventuregame.cards.spells;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Spell extends ACard {

    public Spell(String name) {
        super(name);
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
