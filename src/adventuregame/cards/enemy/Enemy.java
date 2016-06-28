package adventuregame.cards.enemy;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public abstract class Enemy extends ACard {
    
    public enum EnemyType {DEMON, OZYWIENIEC, POTWOR, DUCH, SMOK, KULT, ZWIERZE, OBCY, UNIKAT}
        
    private int power;
    private EnemyType enemyType;
    private final boolean trophy;
    private final int amountInDeck;
    
    public Enemy(String name, int priority, int power, EnemyType enemyType, int amountInDeck, boolean trophy) {
        super(name, priority, false, false);
        this.power = power;
        this.enemyType = enemyType;
        this.trophy = trophy;
        this.amountInDeck = amountInDeck;
    }

    public int getPower() {
        return power;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public boolean isTrophy() {
        return trophy;
    }
    
    @Override
    public void mainAction(Board board, Explorers explorers) {};
    
    
    public void actionBeforeFight(Board board, Explorers explorers) {
        writeCardText(board.getDialog());
    }
    
    public void actionAfterLose(Board board, Explorers explorers) {
        if (isTrophy())
            explorers.getActualExplorer().gainTrophy(this);
    }
    
    public abstract void writeCardText(IDialog dialog);
    
    protected void setPower(int power) {
        this.power = power;
    }
}
