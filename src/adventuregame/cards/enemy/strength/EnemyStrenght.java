package adventuregame.cards.enemy.strength;

import adventuregame.cards.enemy.Enemy;
import adventuregame.explorer.Explorer;

/**
 *
 * @author Fake
 */
public abstract class EnemyStrenght extends Enemy {
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType) {
        super(name, 2, strength, enemyType);
    }
    
    public int getExplorerAdditionalStats(Explorer explorer) {
        int additionalStrength = 0;
        additionalStrength += explorer.getStrengthFromFriends();
        additionalStrength += explorer.getStrengthFromEquippableItems();
        additionalStrength += explorer.getStrengthFromNonEquippableItems();
        return additionalStrength;
    }
    
}
