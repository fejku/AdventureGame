package adventuregame.cards.enemy;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Enemy extends ACard{
    
    public enum EnemyType {DEMON, OZYWIENIEC, POTWOR, DUCH, SMOK, KULT, ZWIERZE, OBCY, UNIKAT}
        
    private final int power;
    private final EnemyType enemyType;

    public Enemy(String name, int priority, int strength, EnemyType enemyType) {
        super(name, priority, false, false);
        this.power = strength;
        this.enemyType = enemyType;
    }

    public int getPower() {
        return power;
    }

    public EnemyType getEnemyType() {
        return enemyType;
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
