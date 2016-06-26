package adventuregame.cards.friend;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Friend extends ACard {

    private int strengthModifier;
    private int craftModifier;
    
    public Friend(String name, boolean interrupt, boolean stay, int strengthModifier, int craftModifier) {
        super(name, 5, interrupt, stay);
        this.strengthModifier = strengthModifier;
        this.craftModifier = craftModifier;
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getStrengthModifier() {
        return strengthModifier;
    }

    public int getCraftModifier() {
        return craftModifier;
    }

}
