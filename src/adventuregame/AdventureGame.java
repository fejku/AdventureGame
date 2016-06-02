package adventuregame;

import adventuregame.explorer.Explorer;
import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.Filozof;
import adventuregame.utils.Dice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fake
 */
public class AdventureGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dice dice = new Dice();
        Board b = new Board(dice);
        //Explorer p = new Filozof();
        Explorers explorers = new Explorers();
        List<Integer> moves = new ArrayList<>();
        
        explorers.pickExplorers();
        do {
            if (explorers.getActualExplorer().isLosesTurn()) {
                explorers.getActualExplorer().passLoseTurn();
            } else {
                System.out.println(explorers.getActualExplorer().writeStats());
                //Pokaż możliwe ruchy
                moves = b.availableMoves(explorers.getActualExplorer().getActualPosition());
                for (int i = 0; i < moves.size(); i++) {
                    System.out.println(i+". Available move: "+moves.get(i));
                }
                //Wykonaj wybór ruchu
                System.out.print("Select move: ");
                int selectedMove = Integer.parseInt(System.console().readLine());
                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
                //Karty na polu
                if(b.isCardOnField(explorers.getActualExplorer().getActualPosition())) {
                    //Akcja karty
                    //b.
                } else {
                    //Akcja pola
                    b.fieldAction(explorers);
                }
                System.out.println(explorers.getActualExplorer().writeStats());
            }
            //Next player
            explorers.nextExplorerTurn();
        } while (true);
        //s.close();
    }
    
}
