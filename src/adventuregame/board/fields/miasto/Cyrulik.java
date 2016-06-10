package adventuregame.board.fields.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;

public class Cyrulik extends ACitizen {

	public Cyrulik() {
		super("Cyrulik");
	}

	@Override
	public boolean isValid(Explorer explorer) {
		if (explorer.getMaxRegainLife() > 0)
			return true;
		else
			return false;
	}
	
    /**
     * Odzyskujesz do 2 punktów życia płacąc za każdy z nich 1 sztukę złota.
     * @param explorer Aktualny Poszukiwacz
     */
	@Override
	public void Action(Board board, Explorer explorer) {
		int maxRegainLife = explorer.getMaxRegainLife();
        if (maxRegainLife == 1) {
            explorer.regainLife();
            explorer.loseGold();
        } else {
        	if (maxRegainLife > 2)
        		maxRegainLife = 2;
        	String[] lifeAmount = new String[maxRegainLife];
        	for (int i = 1; i < maxRegainLife; i++)
        		lifeAmount[i] = Integer.toString(i);
        	int choice = board.getDialog().chooseOption("Ile punktów zdrowia chcesz wyleczyć?", lifeAmount);
            explorer.gainLife(choice);
            explorer.loseGold(choice);
        }
	}
}
