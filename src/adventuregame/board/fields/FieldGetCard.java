package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class FieldGetCard extends Field{

    public FieldGetCard(String name) {
        super(name);
    }

    @Override
    public void action(Board board, Explorers explorers) {
        getCards().add(board.getCardFromDeck());
        for (int i = 0; i < getCards().size(); i++) {
            getCards().get(i).Action(board, explorers);
        }
    }
    
}
