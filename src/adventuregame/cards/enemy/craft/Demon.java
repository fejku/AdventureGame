package adventuregame.cards.enemy.craft;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Demon extends EnemyCraft {
    
    public Demon() {
        super("Demon", 10, EnemyType.DEMON);
    }   

    @Override
    public void writeCardText(IDialog dialog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
