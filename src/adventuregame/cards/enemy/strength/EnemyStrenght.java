package adventuregame.cards.enemy.strength;

import adventuregame.cards.enemy.Enemy;

/**
 *
 * @author Fake
 */
public abstract class EnemyStrenght extends Enemy {
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType) {
        super(name, 2, strength, enemyType);
    }
    
}
