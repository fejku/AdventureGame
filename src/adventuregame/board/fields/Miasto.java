package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Miasto extends Field{
    public Miasto() {
        super("Miasto");
    }

    @Override
    public void action(Board board, Explorers explorers) {      
        int choice;
        boolean isValid;
        
        do {            
            choice = board.getDialog().chooseOption("Możesz odwiedzić:", new String[]{"Cyrulika", "Alchemika", "Czarodziejkę"});
            switch (choice) {
                case 0:
                        isValid = validateCyrulik(explorers.getActualExplorer());
                        break;
                case 1:
                        isValid = validateAlchemik(explorers.getActualExplorer());
                        break;
                default:
                        isValid = true;
                        break;
            }
        } while(!isValid);
        
        switch(choice) {
            case 0:
                    visitCyrulik(board.getDialog(), explorers.getActualExplorer());
                    break;
            case 1:
                    visitAlchemik(board.getDialog(), explorers.getActualExplorer());
                    break;
            case 2:
                    visitCzarodziejka(board, explorers.getActualExplorer());
                    break;
                    
        }
    }
    
    public boolean validateCyrulik(Explorer explorer) {
        if ((explorer.getLife() >= 4) || (explorer.getGold() == 0))
            return false;
        else
            return true;
    }
    
    public boolean validateAlchemik(Explorer explorer) {
        if (explorer.getItems().size() > 0)
            return true;
        else
            return false;
    }
    
    /**
     * Odzyskujesz do 2 punktów życia płacąc za każdy z nich 1 sztukę złota.
     * @param explorer Aktualny Poszukiwacz
     */
    public void visitCyrulik(IDialog dialog, Explorer explorer) {
        if ((explorer.getLife() == 3) || (explorer.getGold() == 1)) {
            explorer.regainLife();
            explorer.loseGold();
        } else {
            int lifeAmount = dialog.choose("Ile życia chcesz odzyskać?", 2);
            explorer.gainLife(lifeAmount);
            explorer.loseGold(lifeAmount);
        }
    }
    
    /**
     * Możesz zamienić swoje Przedmioty w złoto. 
     * Za każdą odrzuconą kartę Przedmiotu, otrzymujesz 1 sztukę złota.
     * @param explorer Aktualny Poszukiwacz
     */
    public void visitAlchemik(IDialog dialog, Explorer explorer) {
        List<Card> items = explorer.getItems();
        String[] itemsNames = new String[items.size()];
        
        for (int i = 0; i < items.size(); i++) {
            itemsNames[i] = items.get(i).getName();
        }
        
        int chosenItem = dialog.chooseOption("Wybierz przedmiot, który chcesz zamienić na złoto:", itemsNames);
        explorer.removeItem(chosenItem);
        explorer.gainGold();
        
        if (dialog.chooseYesNo("Zamienić kolejny przedmiot?")) {
            if (explorer.getItems().size() == 1) {
                explorer.removeItem(chosenItem);
                explorer.gainGold();
            } else if (explorer.getItems().size() > 1) {
                visitAlchemik(dialog, explorer);
            }
        }
    }
    
    /**
     * Czarodiejka (Rzuć 1 kością)
     * 1. Zostajesz zamieniony w ropuchę
     * 2. Tracisz 1 punkt Siły
     * 3. Tracisz 1 punkt Mocy
     * 4. Otrzymujesz 1 punkt Mocy
     * 5. Otrzymujesz 1 punkt Siły
     * 6. Otrzymujesz 1 Zaklęcie
     */
    public void visitCzarodziejka(Board board, Explorer explorer) {
        int diceResult = board.getDice().throwDice();
        switch(diceResult) {
            case 0:
                    explorer.changeIntoToad();
                    break;
            case 1:
                    explorer.loseStrength();
                    break;
            case 2:
                    explorer.loseCraft();
                    break;
            case 3:
                    explorer.gainCraft();
                    break;
            case 4:
                    explorer.gainStrength();
                    break;
            case 5:
                    explorer.gainSpell(board);
                    break;
        }
    }
}
