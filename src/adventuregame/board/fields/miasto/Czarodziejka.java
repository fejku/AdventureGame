package adventuregame.board.fields.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;

public class Czarodziejka extends ACitizen {

	public Czarodziejka() {
		super("Czarodziejka");
	}

    /**
     * Czarodziejka (Rzuć 1 kością)
     * 1. Zostajesz zamieniony w ropuchę
     * 2. Tracisz 1 punkt Siły
     * 3. Tracisz 1 punkt Mocy
     * 4. Otrzymujesz 1 punkt Mocy
     * 5. Otrzymujesz 1 punkt Siły
     * 6. Otrzymujesz 1 Zaklęcie
     */
	@Override
	public void Action(Board board, Explorer explorer) {
        switch(board.getDice().throwDice()) {
            case 1:
                board.getDialog().message("Zostajesz zamieniony w ropuchę.");
                explorer.changeIntoToad();
                break;
            case 2:
                board.getDialog().message("Tracisz 1 punkt Siły.");
                explorer.loseStrength();
                break;
            case 3:
                board.getDialog().message("Tracisz 1 punkt Mocy.");
                explorer.loseCraft();
                break;
            case 4:
                board.getDialog().message("Otrzymujesz 1 punkt Mocy.");
                explorer.gainCraft();
                break;
            case 5:
                board.getDialog().message("Otrzymujesz 1 punkt Siły.");
                explorer.gainStrength();
                break;
            case 6:
                board.getDialog().message("Otrzymujesz 1 Zaklęcie.");
                //explorer.gainSpell(board);
                break;
        }
	}

}
