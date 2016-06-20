package adventuregame;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
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
public class Game {
    
    public enum GameState {
        CHECK_LOST_TURN,
        BEFORE_ROLL,
        MOVEMENT_CHOICE,
        BEFORE_FIELD_ACTION,
        POST_MOVEMENT,
        TURN_END,        
        GAME_END
    }
    
    private final Board board;
    private final Explorers explorers;
    private final IDialog dialog;
    private final Dice dice;

    private GameState actualState;        
    
    public Game() {
        actualState = GameState.CHECK_LOST_TURN;
        dialog = new ConsoleDialog();
        dice = new Dice();
        board = new Board(dialog, dice, actualState);
        explorers = new Explorers();
    }
    
    public void initBoard() {
        explorers.pickExplorers();
    }
    
    public void mainLoop() {
        while(actualState != GameState.GAME_END) {
            turn();
        }
    }
    
    private void turn() {
        switch(actualState) {
            case CHECK_LOST_TURN:
                board.getDialog().message("************* POCZATEK TURY *******************");
                if (explorers.getActualExplorer().isLosesTurn()) {
                    explorers.getActualExplorer().passLoseTurn();
                    actualState = GameState.TURN_END;
                } else {
                    actualState = GameState.BEFORE_ROLL;
                }
                break;
            case BEFORE_ROLL:
                board.getDialog().message(explorers.getActualExplorer().writeStats());
                actualState = GameState.MOVEMENT_CHOICE;
                break;
            case MOVEMENT_CHOICE:
                List<Integer> moves = board.availableMoves(explorers.getActualExplorer());
                for (int i = 0; i < moves.size(); i++) {
                    board.getDialog().message(i + ". " + board.getField(moves.get(i)).getName() + " (" + moves.get(i) + ")");
                }
                int selectedMove = board.getDialog().choose(moves.size());
                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
                actualState = GameState.BEFORE_FIELD_ACTION;
                break;
            case BEFORE_FIELD_ACTION:
                actualState = GameState.POST_MOVEMENT;
                break;
            case POST_MOVEMENT:
                if(board.isCardOnField(explorers.getActualExplorer().getActualPosition())) {
                    //Akcja karty
                    //b.
                    board.fieldAction(explorers);
                } else {
                    //Akcja pola
                    board.fieldAction(explorers);
                }
                board.getDialog().message(explorers.getActualExplorer().writeStats());
                actualState = GameState.TURN_END;
                break;
            case TURN_END:
                explorers.nextExplorerTurn();
                board.getDialog().message("************* KONIEC TURY *******************");   
                actualState = GameState.CHECK_LOST_TURN;
                break;
            case GAME_END:
                //return GameState.GAME_END;
                break;
            default:
                throw new IllegalArgumentException("Nie obsłużony stan gry w klasie AdventureGame w metodzie turn.");
        }
    }
}
