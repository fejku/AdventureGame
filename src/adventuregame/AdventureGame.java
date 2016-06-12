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

    public enum GameState {
        CHECK_LOST_TURN,
        BEFORE_ROLL,
        MOVEMENT_CHOICE,
        POST_MOVEMENT,
        TURN_END,
        
        GAME_END
        
//        CHARACTER_CREATION, 
//        BEFORE_ROLL, 
//        MOVEMENT_CHOICE, 
//        POST_MOVEMENT, 
//        BEFORE_COMBAT, 
//        COMBAT_PROJECTION, 
//        PRE_ASSASINATE, 
//        TAKE_TROPHY, 
//        DURING_COMBAT, 
//        WON_COMBAT, 
//        DRAW_COMBAT, 
//        LOST_COMBAT, 
//        POST_COMBAT, 
//        ANY, 
//        GAME_START, 
//        SPACE_INTERACTION, 
//        ITEM_SELECTION, 
//        CAST_SPELL, 
//        COMBAT_CHOICE, 
//        COMBAT_ROLL_TWO, 
//        MONK_COMBAT, 
//        ATTACK_LESSER, 
//        AID_COMBAT, 
//        ANIMALS_DRAGONS
    }
    
    static List<Integer> moves = new ArrayList<>();   
    static int selectedMove;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        IDialog dialog = new ConsoleDialog();
        Dice dice = new Dice();
        
        Board b = new Board(dialog, dice);
        Explorers explorers = new Explorers();

        
        explorers.pickExplorers();
        do {
//dialog.message("************* POCZATEK TURY *******************");
//            if (explorers.getActualExplorer().isLosesTurn()) {
//                explorers.getActualExplorer().passLoseTurn();
//            } else {
//                dialog.message(explorers.getActualExplorer().writeStats());
//                //Pokaż możliwe ruchy
//                moves = b.availableMoves(explorers.getActualExplorer());
//                for (int i = 0; i < moves.size(); i++) {
//                    dialog.message(i + ". " + b.getField(moves.get(i)).getName() + " (" + moves.get(i) + ")");
//                }
//                //Wykonaj wybór ruchu              
//                int selectedMove = dialog.choose(moves.size());
//                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
//                //Karty na polu
//                if(b.isCardOnField(explorers.getActualExplorer().getActualPosition())) {
//                    //Akcja karty
//                    //b.
//                } else {
//                    //Akcja pola
//                    b.fieldAction(explorers);
//                }
//                dialog.message(explorers.getActualExplorer().writeStats());
//            }
//dialog.message("************* KONIEC TURY *******************");            
            //Next player
//            explorers.nextExplorerTurn();
            turn(b, explorers, GameState.CHECK_LOST_TURN);
        } while (true);
        //s.close();
    }
    
    public static void turn(Board board, Explorers explorers, GameState gameState) {
        switch(gameState) {
            case CHECK_LOST_TURN:
                board.getDialog().message("************* POCZATEK TURY *******************");
                if (explorers.getActualExplorer().isLosesTurn()) {
                    explorers.getActualExplorer().passLoseTurn();
                    turn(board, explorers, GameState.TURN_END);
                } else {
                    turn(board, explorers, GameState.BEFORE_ROLL);
                }
                break;
            case BEFORE_ROLL:
                board.getDialog().message(explorers.getActualExplorer().writeStats());
                turn(board, explorers, GameState.MOVEMENT_CHOICE);
                break;
            case MOVEMENT_CHOICE:
                moves = board.availableMoves(explorers.getActualExplorer());
                for (int i = 0; i < moves.size(); i++) {
                    board.getDialog().message(i + ". " + board.getField(moves.get(i)).getName() + " (" + moves.get(i) + ")");
                }
                selectedMove = board.getDialog().choose(moves.size());
                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
                turn(board, explorers, GameState.POST_MOVEMENT);
                break;
            case POST_MOVEMENT:
                if(board.isCardOnField(explorers.getActualExplorer().getActualPosition())) {
                    //Akcja karty
                    //b.
                } else {
                    //Akcja pola
                    board.fieldAction(explorers);
                }
                board.getDialog().message(explorers.getActualExplorer().writeStats());
                turn(board, explorers, GameState.TURN_END);
                break;
            case TURN_END:
                explorers.nextExplorerTurn();
                board.getDialog().message("************* KONIEC TURY *******************");                
                break;
            case GAME_END:
                //return GameState.GAME_END;
                break;
            default:
                throw new IllegalArgumentException("Nie obsłużony stan gry w klasie AdventureGame w metodzie turn.");
        }
    }
    
}
