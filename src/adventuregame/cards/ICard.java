package adventuregame.cards;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

public interface ICard {
    public String getName();
    public int getPriority();
    public void action(Board board, Explorers explorers);
    public void mainAction(Board board, Explorers explorers);
    public void afterAction(Board board, Explorers explorers);
}
