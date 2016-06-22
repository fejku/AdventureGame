package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Kapliczka extends ActionField {
    public Kapliczka() {
        super("Kapliczka");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        Explorer actualExplorer = explorers.getActualExplorer();
        switch(actualExplorer.getCharacter()) {
            case ZLY:
            	evilAction(board, actualExplorer);
                break;
            case NEUTRALNY:
            	neutralAction(board.getDialog(), actualExplorer);
                break;
            case DOBRY:
            	goodAction(board.getDialog(), board.getDice(), actualExplorer);
                break;
                
        }
    }
    
    private void evilAction(Board board, Explorer explorer) {
        board.getDialog().message("Tracisz 1 punkt wytrzymałości.");
        explorer.loseLife(board);
    }
    
    private void neutralAction(IDialog dialog, Explorer explorer) {
    	//Ustalanie maksymalnej ilości życia jaką można odzyskać i na ile pozwala posiadane złoto
    	int maxRegainLife = explorer.getMaxRegainLife();
    	//Można odzyskać życie
        if (maxRegainLife > 0) {
            dialog.message("Możesz zostać wyleczony z ran, płacąc 1 mieszek złota za 1 odzyskany punkt Wytrzymałości.");
            if(dialog.chooseYesNo("Korzystasz?")) {
            	//Tylko jeden mieszek lub 1 ustracony punkt Wytrzymałości
            	if (maxRegainLife == 1) {
                    explorer.loseGold();
                    explorer.regainLife();
            	} else {            	
                    //Lista możliwych do odzyskania punktów Wytrzymałości 
                    String[] lifeAmount = new String[maxRegainLife];
                    for (int i = 1; i < maxRegainLife; i++)
                        lifeAmount[i] = Integer.toString(i);
                    int choise = dialog.chooseOption("Ile punktów zdrowia chcesz wyleczyć?", lifeAmount);
                    explorer.loseGold(choise);
                    explorer.gainLife(choise);
            	}
            }
        } else
            dialog.message("Nie możesz zostać wyleczony, ponieważ jesteś w pełni zdrów bądź masz niewystarczającą ilość złota.");
    }
    
    private void goodAction(IDialog dialog, Dice dice, Explorer explorer) {
    	int maxRegainLife = explorer.getMaxRegainLife();
    	if (maxRegainLife == 0) {
            pray(dialog, dice, explorer);
    	} else {
            dialog.message("Możesz zostać uleczony za darmo do ilości punktów Wytrzymałości z początku wędrówki lub możesz się modlić rzucając kością.");
            if (dialog.chooseYesNo("Chcesz zostać uleczony?"))
                explorer.gainLife(explorer.getMissingLife());
            else
                pray(dialog, dice, explorer);
    	}
    }
    
    private void pray(IDialog dialog, Dice dice, Explorer explorer) {
    	switch(dice.throwDice()) {
            case 1:
            case 2:
            case 3:
            case 4:
                //1-4 Zostałeś zignorowany
                dialog.message("Zostałeś zignorowany.");
                break;
            case 5:
                //5 Zyskujesz 1 punkt Wytrzymałości
                dialog.message("Zyskujesz 1 punkt Wytrzymałości.");
                explorer.gainLife();
                break;
            case 6:
                dialog.message("Zyskujesz 1 Czar.");
                //explorers.getActualExplorer().gainSpell(board);
                break;   
            default:
                throw new IndexOutOfBoundsException("Błąd w klasie Kapliczka w metodzie pray. Brak akcji dla uzyskanego wyniku rzutu kostką.");                            
    	}
    }
}
