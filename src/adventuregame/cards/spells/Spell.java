package adventuregame.cards.spells;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Spell extends Card {

    public Spell(String name) {
        super(name);
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
