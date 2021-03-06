package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightType;

/**
 *
 * @author Fake
 */
public class Gospoda extends ActionField {
    public Gospoda() {
        super("Gospoda");
    }

    @Override
    public void action(Board board, Explorers explorers) {
        switch(board.getDice().throwDice()) {
            case 1: 
                //Upiłeś się i zasnąłeś w kącie. Tracisz następną turę.
                board.getDialog().message("Upiłeś się i zasnąłeś w kącie. Tracisz następną turę.");
                explorers.getActualExplorer().loseTurn();
                break;
            case 2:
                //Upiłeś się i wdałeś w bójkę z miejscowym osiłkiem (Siła: 3)
                board.getDialog().message("Upiłeś się i wdałeś w bójkę z miejscowym osiłkiem (Siła: 3).");
                fightWithoutCard(board, explorers.getActualExplorer(), FightType.STRENGTH, 3);
                break;
            case 3:
                //Grałeś w karty i przegrałeś 1 sztukę złota
                board.getDialog().message("Grałeś w karty i przegrałeś 1 sztukę złota.");            	
                explorers.getActualExplorer().loseGold();                    
                break;
            case 4:
                //Grałeś w karty i wygrałeś sztukę złota
                board.getDialog().message("Grałeś w karty i wygrałeś sztukę złota.");            	
                explorers.getActualExplorer().gainGold();
                break;
            case 5:
                //Czarownik obiecuje teleportować cię do dowolnego miejsca w tej krainie. To może być twój następny ruch.
                board.getDialog().message("Czarownik obiecuje teleportować cię do dowolnego miejsca w tej krainie. To może być twój następny ruch.");            	
                explorers.getActualExplorer().addNextMove(Region.OUTER, explorers.getActualExplorer().getActualPosition());                    
                break;
            case 6:
                //Przewoźnik ofiaruje ci przeprawę do Świątyni. To może być twój następny ruch.
                board.getDialog().message("Przewoźnik ofiaruje ci przeprawę do Świątyni. To może być twój następny ruch.");            	
                explorers.getActualExplorer().addNextMove(Field.SWIATYNIA, explorers.getActualExplorer().getActualPosition());
                break;
            default:
                throw new IndexOutOfBoundsException("Błąd w klasie Gospoda w metodzie action. Brak akcji dla uzyskanego wyniku rzutu kostką.");                
        }
    }
    
}
