package adventuregame.cards.enemy.craft;

import adventuregame.cards.enemy.Enemy;

/**
 *
 * @author Fake
 */
public abstract class EnemyCraft extends Enemy {
    
    public EnemyCraft(String name, int craft, EnemyType enemyType) {
        super(name, 3, craft, enemyType);
    }
    
}
