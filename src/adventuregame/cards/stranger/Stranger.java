package adventuregame.cards.stranger;

import adventuregame.cards.ACard;

/**
 *
 * @author Fake
 */
public abstract class Stranger extends ACard {

    public Stranger(String name, boolean interrupt, boolean stay) {
        super(name, 4, interrupt, stay);
    }
}
