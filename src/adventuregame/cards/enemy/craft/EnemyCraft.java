package adventuregame.cards.enemy.craft;

import adventuregame.cards.enemy.Enemy;

/**
 *
 * @author Fake
 */
public abstract class EnemyCraft extends Enemy {
    
    public EnemyCraft(String name, int craft, EnemyType enemyType, int amountInDeck, boolean trophy) {
        super(name, 3, craft, enemyType, amountInDeck, trophy);
    }
    
    public EnemyCraft(String name, int craft, EnemyType enemyType, int amountInDeck) {
        this(name, craft, enemyType, amountInDeck, true);
    }
    
    public EnemyCraft(String name, int craft, EnemyType enemyType) {
        this(name, craft, enemyType, 1);
    }
}
