package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class ACard implements ICard {
    
    private final String name;
    private final int priority;
    private final boolean interrup;
    private final boolean stay;
    
    public ACard(String name, int priority, boolean interrupt, boolean stay) {
        this.name = name;
        this.priority = priority;
        this.interrup = interrupt;
        this.stay = stay;
    }
    
    public void action(Board board, Explorers explorers) {
        board.getDialog().message("Wylosowana karta: " + getName());
        mainAction(board, explorers);
        afterAction(board, explorers);
    }

    public String getName() {
        return name;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void afterAction(Board board, Explorers explorers) {};
    
    public boolean isInterupting() {
        return interrup;
    }
    
    public boolean isStaying() {
        return stay;
    }
}
