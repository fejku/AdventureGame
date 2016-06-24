package adventuregame.cards.friend;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Friend extends ACard {

    private int strengthModifier;
    
    public Friend(String name, boolean interrupt, boolean stay, int strengthModifier) {
        super(name, 5, interrupt, stay);
        this.strengthModifier = strengthModifier;
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getStrengthModifier() {
        return strengthModifier;
    }

}
