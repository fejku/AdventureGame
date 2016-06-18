package adventuregame.cards.events;

import adventuregame.cards.ACard;

/**
 *
 * @author Fake
 */
public abstract class Event extends ACard {
    
    public Event(String name, boolean interrupt) {
        super(name, 1, interrupt, false);
    }
    
}
