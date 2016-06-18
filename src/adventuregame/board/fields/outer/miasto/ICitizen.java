package adventuregame.board.fields.outer.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;

public interface ICitizen {
    public String getName();
    public boolean isValid(Explorer explorer);
    public void action(Board board, Explorer explorer);
}
