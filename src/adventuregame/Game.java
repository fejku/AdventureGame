package adventuregame;

import java.util.List;

import adventuregame.board.Board;
import adventuregame.board.Board.GameState;
import adventuregame.explorer.Explorers;
import adventuregame.utils.ConsoleDialog;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Game {

    private final Board board;
    private final Explorers explorers;
    private final IDialog dialog;
    private final Dice dice;        
    
    public Game() {
        dialog = new ConsoleDialog();
        dice = new Dice();
        board = new Board(dialog, dice);
        explorers = new Explorers();
    }
    
    public void initBoard() {
        explorers.pickExplorers();
    }
    
    public void mainLoop() {
        while(board.getGameState() != GameState.GAME_END) {
            turn();
        }
    }
    
    private void turn() {
        switch(board.getGameState()) {
            case CHECK_LOST_TURN:
                board.getDialog().message("************* POCZATEK TURY *******************");
                if (explorers.getActualExplorer().isLosesTurn()) {
                    explorers.getActualExplorer().passLoseTurn();
                    board.setGameState(GameState.TURN_END);
                } else {
                	board.setGameState(GameState.BEFORE_ROLL);
                }
                break;
            case BEFORE_ROLL:
                board.getDialog().message(explorers.getActualExplorer().writeStats());
                board.setGameState(GameState.MOVEMENT_CHOICE);
                break;
            case MOVEMENT_CHOICE:
                List<Integer> moves = board.availableMoves(explorers.getActualExplorer());
                for (int i = 0; i < moves.size(); i++) {
                    board.getDialog().message(i + ". " + board.getField(moves.get(i)).getName() + " (" + moves.get(i) + ")");
                }
                int selectedMove = board.getDialog().choose(moves.size());
                explorers.getActualExplorer().setActualPosition(moves.get(selectedMove));
                board.setGameState(GameState.BEFORE_FIELD_ACTION);                
                break;
            case BEFORE_FIELD_ACTION:
            	board.setGameState(GameState.POST_MOVEMENT);
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
                if (board.getGameState() == GameState.POST_MOVEMENT)
                	board.setGameState(GameState.TURN_END);
                break;
            case TURN_END:
                explorers.nextExplorerTurn();
                board.getDialog().message("************* KONIEC TURY *******************");  
                board.setGameState(GameState.CHECK_LOST_TURN);
                break;
            case GAME_END:
                //return GameState.GAME_END;
                break;
            default:
                throw new IllegalArgumentException("Nie obsłużony stan gry w klasie AdventureGame w metodzie turn.");
        }
    }
}
