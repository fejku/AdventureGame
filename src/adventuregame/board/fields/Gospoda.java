/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Gospoda extends Field {
    public Gospoda() {
        super("Gospoda");
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        switch(board.getDice().throwDice()) {
            case 1: 
                    //Upiłeś się i zasnąłeś w kącie. Tracisz następną turę.
                    explorers.getActualExplorer().addLostTurn(1);
                    break;
            case 2:
                    //Upiłeś się i wdałeś w bójkę z miejscowym osiłkiem (Siła: 3)
                    int enemyStrength = 3 + board.getDice().throwDice();
                    int explorerStrength = explorers.getActualExplorer().getStrength() + board.getDice().throwDice();
                    if (enemyStrength > explorerStrength) {
                        //TODO: obrona
                        explorers.getActualExplorer().subtractLife();
                    }
                    break;
            case 3:
                    //Grałeś w karty i przegrałeś 1 sztukę złota
                    explorers.getActualExplorer().subGold(1);
                    break;
            case 4:
                    //Grałeś w karty i wygrałeś sztukę złota
                    explorers.getActualExplorer().addGold(1);
                    break;
            case 5:
                    //Czarownik obiecuje teleportować cię do dowolnego miejsca w tej krainie. To może być twój następny ruch.
                    //TODO
                    break;
            case 6:
                    //Przewoźnik ofiaruje ci przeprawę do Świątyni. To może być twój następny ruch.
                    //TODO
                    break;
        }
    }
    
}
