package adventuregame.board.fields.outer;

import adventuregame.board.fields.Field;

/**
 *
 * @author Fake
 */
public abstract class OuterField extends Field {

    public OuterField(String name, int amountDrawingCards) {
        super(name, Region.OUTER, amountDrawingCards);
    }

}
