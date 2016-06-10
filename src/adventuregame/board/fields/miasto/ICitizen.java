package adventuregame.board.fields.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;

public interface ICitizen {
	public String getName();
	public boolean isValid(Explorer explorer);
	public void Action(Board board, Explorer explorer);
}
