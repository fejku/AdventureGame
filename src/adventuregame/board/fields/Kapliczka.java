/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Kapliczka extends Field {
    public Kapliczka() {
        super("Kapliczka");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        Explorer actualExplorer = explorers.getActualExplorer();
        switch(actualExplorer.getCharacter()) {
            case ZLY:
                board.getDialog().message("Tracisz 1 punkt wytrzymałości.");
                actualExplorer.loseLife();
                break;
            case NEUTRALNY:
                if ((explorers.getActualExplorer().getGold() > 0) && (explorers.getActualExplorer().getLife() < 4)) {
                    board.getDialog().message("Możesz zostać wyleczony z ran, płacąc 1 mieszek złota za 1 odzyskany punkt Wytrzymałości.");
                    if(board.getDialog().chooseYesNo("Korzystasz?")) {
                        explorers.getActualExplorer().loseGold();
                        explorers.getActualExplorer().gainLife();
                    }
                }
                break;
            case DOBRY:
                break;
                
        }
//        if (actualExplorer.getCharacter() == ExplorerCharacter.ZLY) {
//            
//        } else if*()
//        else if (actualExplorer.getCharacter() == ExplorerCharacter.ZLY) {
//            switch(board.getDice().throwDice()) {
//                case 1:
//                    //1. Tracisz 1 turę.
//                    board.getDialog().message("Tracisz 1 turę.");
//                    actualExplorer.loseLife();
//                    break;
//                case 2: 
//                case 3:
//                    //2-3. Leczysz 1 punkt Wytrzymałości
//                    board.getDialog().message("Leczysz 1 punkt Wytrzymałości.");
//                    actualExplorer.regainLife();
//                    break;
//                case 4:
//                case 5:
//                case 6:       
//                    //4-6. Zyskujesz 1 Czar 
//                    board.getDialog().message("Zyskujesz 1 Czar.");
//                    //explorers.getActualExplorer().gainSpell(board);
//                    break;
//            }
//        }
    }
    
    
}
