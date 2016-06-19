package adventuregame.cards.enemy;

import adventuregame.Game.GameState;
import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Enemy extends ACard{
    
    private final int power;

    public Enemy(String name, int priority, int strength) {
        super(name, priority, false, false);
        this.power = strength;
    }

    public int getPower() {
        return power;
    }
    
    @Override
    public void mainAction(Board board, Explorers explorers) {
        Explorer actExp = explorers.getActualExplorer();
        
        System.out.println("Przeciwnik " + getName() + " siła: " + getPower());
        int foeStrenght = getPower() + board.getDice().throwDice();
        System.out.println("Sila przeciwnika po rzucie: "+foeStrenght);
        System.out.println(actExp.writeStats());
        int explorerStrenght = actExp.getStrength() +
            board.getDice().throwDice();
        System.out.println("Sila poszukiwacza po rzucie: " + explorerStrenght);
        if(explorerStrenght>foeStrenght) {
            //Usunięcie karty z pola
            board.getField(actExp.getActualPosition()).removeCardFromField(this);
            //Dodanie karty potwora do pokonanych
            actExp.addCreature(this);
            System.out.println("Poszukiwacz wygral!");
        } else if(explorerStrenght==foeStrenght)
            //Nic się nie dzieje
            System.out.println("Remis");
        else {
            //Strata punktu wytrzymałości
            System.out.println("Przeciwnik wygral :(");
            actExp.loseLife(board);
            System.out.println(actExp.writeStats());
        }
    }
}
