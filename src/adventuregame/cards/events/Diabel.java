package adventuregame.cards.events;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

public class Diabel extends Event {

	public Diabel() {
		super("Diabeł", false);
	}

	@Override
	public void mainAction(Board board, Explorers explorers) {
		board.getDialog().message("Diabeł wpadł do ciebie z wizytą. Jeżeli jesteś Zły, otrzymujesz od niego 1 punkt Wytrzymałości, jeśli Dobry diabeł zabiera ci 1 punkt Wytrzymałości. Neutralnych diabeł ignoruje. Potem diabeł znika jak się pojawił. Odłoż tę Kartę.");
		switch(explorers.getActualExplorer().getCharacter()) {
			case ZLY:
				explorers.getActualExplorer().gainLife();
				break;
			case DOBRY:
				explorers.getActualExplorer().loseLife(board);
		}
	}

}
