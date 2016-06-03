package adventuregame;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;
import adventuregame.utils.ConsoleDialog;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class AdventureGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IDialog dialog = new ConsoleDialog();
        Dice dice = new Dice();
        
        Board b = new Board(dialog, dice);
        Explorers explorers = new Explorers();
        List<Integer> moves = new ArrayList<>();
        
        explorers.pickExplorers();
        do {
            if (explorers.getActualExplorer().isLosesTurn()) {
                explorers.getActualExplorer().passLoseTurn();
            } else {
                dialog.message(explorers.getActualExplorer().writeStats());
                //Pokaż możliwe ruchy
                moves = b.availableMoves(explorers.getActualExplorer().getActualPosition());
                for (int i = 0; i < moves.size(); i++) {
                    dialog.message(i + ". " + moves.get(i));
                }
                //Wykonaj wybór ruchu              
                int selectedMove = dialog.choose(moves.size());
                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
                //Karty na polu
                if(b.isCardOnField(explorers.getActualExplorer().getActualPosition())) {
                    //Akcja karty
                    //b.
                } else {
                    //Akcja pola
                    b.fieldAction(explorers);
                }
                dialog.message(explorers.getActualExplorer().writeStats());
            }
            //Next player
            explorers.nextExplorerTurn();
        } while (true);
        //s.close();
    }
    
}
