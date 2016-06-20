package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

public class Patrol extends Event {

	public Patrol() {
		super("Patrol", true);
	}

	@Override
	public void mainAction(Board board, Explorers explorers) {
		board.getDialog().message("Patrol wojska usiłuje wprowadzić ład i porządek. Żołnierze odsyłają cię natychmiast na Obszar, z którego rozpoczynałeś grę i zadowoleni odmaszerowują do koszar. Odłóż tę Kartę.");
		
		explorers.getActualExplorer().setActualPosition(explorers.getActualExplorer().getStartingPosition());
	}

}
