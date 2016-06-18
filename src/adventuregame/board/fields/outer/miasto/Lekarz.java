package adventuregame.board.fields.outer.miasto;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;

public class Lekarz extends ACitizen {

    public Lekarz() {
        super("Lekarz");
    }

    @Override
    public boolean isValid(Explorer explorer) {
        if (explorer.getMaxRegainLife() > 0)
            return true;
        else
            return false;
    };

    //HEALER: The Healer will restore Lives at the price of 1 Gold Coin each, back
    //up to your starting quota	
    @Override
    public void action(Board board, Explorer explorer) {
        int maxRegainLife = explorer.getMaxRegainLife();
        if (maxRegainLife == 1) {
            explorer.regainLife();
            explorer.loseGold();
        } else {
            String[] lifeAmount = new String[maxRegainLife];
            for (int i = 1; i < maxRegainLife; i++)
                lifeAmount[i] = Integer.toString(i);
            int choice = board.getDialog().chooseOption("Ile punktów zdrowia chcesz wyleczyć?", lifeAmount);
            explorer.gainLife(choice);
            explorer.loseGold(choice);
        }
    }

}
