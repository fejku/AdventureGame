/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

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
                case 1:
                        isValid = validateCyrulik(explorers.getActualExplorer());
                case 2:
                        isValid = validateAlchemik(explorers.getActualExplorer());
                default:
                        isValid = true;
            }
        } while(!isValid);
        
        switch(choice) {
            case 1:
                    visitCyrulik(board.getDialog(), explorers.getActualExplorer());
                    break;
        }
        switch (board.getDice().throwDice()) {
            
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
        String[] a = {"aa", "bb"};
        //dialog.chooseOption("Wybierz przedmiot", choices)
    }
}
