package adventuregame;

/**
 *
 * @author Fake
 */
public class AdventureGame {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        Game game = new Game();
        game.initBoard();
        game.mainLoop();
    }
    
}
