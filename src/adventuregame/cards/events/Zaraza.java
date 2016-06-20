package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.board.fields.Field.Region;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

public class Zaraza extends Event {

	public Zaraza() {
		super("Zaraza", false);
	}

	@Override
	public void mainAction(Board board, Explorers explorers) {
		board.getDialog().message("Zaraza grasuje w tej Krainie (tylko Zewnętrznej lub Środkowej). Wszyscy znajdujący się w niej Poszukiwacze tracą 1 punkt Wytrzymałości. Potem zaraza znika odłoż tę Kartę.");
		
		Region actualRegion = board.getField(explorers.getActualExplorer().getActualPosition()).getRegion();
		
		if ((actualRegion == Region.OUTER) || (actualRegion == Region.MIDDLE)) {
			for (Explorer explorer : explorers.getExplorers())
				if (board.getField(explorer.getActualPosition()).getRegion() == actualRegion)
					explorer.loseLife(board);
		}
	}

}
