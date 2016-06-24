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
    private final boolean stay;
    
    private boolean interrup;
    private boolean onField;
    
    public ACard(String name, int priority, boolean interrupt, boolean stay) {
        this.name = name;
        this.priority = priority;
        this.interrup = interrupt;
        this.stay = stay;
        this.onField = false;
    }
    
    @Override
    public final void action(Board board, Explorers explorers) {
        board.getDialog().message("Wylosowana karta: " + getName());
        mainAction(board, explorers);
        afterAction(board, explorers);
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getPriority() {
        return priority;
    }
    
    @Override
    public void afterAction(Board board, Explorers explorers) {};
    
    public boolean isInterupting() {
        return interrup;
    }
    
    public boolean isStaying() {
        return stay;
    }
    
    public void setInterrup(boolean interrupt) {
        this.interrup = interrupt;
    }
    
    public boolean isOnField() {
        return onField;
    }

    public void setOnField(boolean onField) {
        this.onField = onField;
    }
    
}
