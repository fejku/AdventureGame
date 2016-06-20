package adventuregame.cards.events;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;

public class ZlaCiemnosc extends Event {

	public ZlaCiemnosc() {
		super("Zła ciemność", false);
	}

	@Override
	public void mainAction(Board board, Explorers explorers) {
		board.getDialog().message("Z Krainy Nicości nadciąga zła ciemność ogarniająca cały świat. Dobrzy i Neutralni Poszukiwacze tracą jedną turę. Później ciemność znika odłóż tę Kartę.");
		
		for (Explorer explorer : explorers.getExplorers())
			if (explorer.getCharacter() != ExplorerCharacter.ZLY)
				explorer.loseTurn();
		
		if (explorers.getActualExplorer().getCharacter() != ExplorerCharacter.ZLY)
			board.setGameState(GameState.TURN_END);
	}

}
