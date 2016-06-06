/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightType;

/**
 *
 * @author Fake
 */
public class Gospoda extends Field {
    public Gospoda() {
        super("Gospoda");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        switch(board.getDice().throwDice()) {
            case 1: 
                    //Upiłeś się i zasnąłeś w kącie. Tracisz następną turę.
                    explorers.getActualExplorer().loseTurn();
                    break;
            case 2:
                    //Upiłeś się i wdałeś w bójkę z miejscowym osiłkiem (Siła: 3)
                    fightWithoutCard(board, explorers.getActualExplorer(), FightType.STRENGTH, 3);
                    break;
            case 3:
                    //Grałeś w karty i przegrałeś 1 sztukę złota
                    explorers.getActualExplorer().loseGold();
                    break;
            case 4:
                    //Grałeś w karty i wygrałeś sztukę złota
                    explorers.getActualExplorer().gainGold();
                    break;
            case 5:
                    //Czarownik obiecuje teleportować cię do dowolnego miejsca w tej krainie. To może być twój następny ruch.
                    explorers.getActualExplorer().addNextMove(FieldType.OUTER);
                    break;
            case 6:
                    //Przewoźnik ofiaruje ci przeprawę do Świątyni. To może być twój następny ruch.
                    explorers.getActualExplorer().addNextMove(Field.SWIATYNIA);
                    break;
        }
    }
    
}
