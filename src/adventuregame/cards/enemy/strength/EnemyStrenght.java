package adventuregame.cards.enemy.strength;

import adventuregame.cards.enemy.Enemy;
import adventuregame.explorer.Explorer;

/**
 *
 * @author Fake
 */
public abstract class EnemyStrenght extends Enemy {
    
    private boolean strengthFromFriends;
    private boolean strengthFromEquippableItems;
    private boolean strengthFromNonEquippableItems;
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType, int amountInDeck, boolean trophy, boolean strengthFromFriends, 
            boolean strengthFromEquippableItems, boolean strengthFromNonEquippableItems) {
        super(name, 2, strength, enemyType, amountInDeck,trophy);
        this.strengthFromFriends = strengthFromFriends;
        this.strengthFromEquippableItems = strengthFromEquippableItems;
        this.strengthFromNonEquippableItems = strengthFromNonEquippableItems;
    }
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType, int amountInDeck, boolean trophy) {
        this(name, strength, enemyType, amountInDeck, trophy, true, true, true);
    }
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType, int amountInDeck) {
        this(name, strength, enemyType, amountInDeck, true);
    }
    
    public EnemyStrenght(String name, int strength, EnemyType enemyType) {
        this(name, strength, enemyType, 1);
    }

    public boolean isStrengthFromFriends() {
        return strengthFromFriends;
    }

    public void setStrengthFromFriends(boolean strengthFromFriends) {
        this.strengthFromFriends = strengthFromFriends;
    }

    public boolean isStrengthFromEquippableItems() {
        return strengthFromEquippableItems;
    }

    public void setStrengthFromEquippableItems(boolean strengthFromEquippableItems) {
        this.strengthFromEquippableItems = strengthFromEquippableItems;
    }

    public boolean isStrengthFromNonEquippableItems() {
        return strengthFromNonEquippableItems;
    }

    public void setStrengthFromNonEquippableItems(boolean strengthFromNonEquippableItems) {
        this.strengthFromNonEquippableItems = strengthFromNonEquippableItems;
    }
    
    public int getExplorerAdditionalStats(Explorer explorer, boolean strengthFromFriends, 
            boolean strengthFromEquippableItems, boolean strengthFromNonEquippableItems) {
        
        int additionalStrength = 0;
        
        if (strengthFromFriends)
            additionalStrength += explorer.getStrengthFromFriends();
        if (strengthFromEquippableItems)
            additionalStrength += explorer.getStrengthFromEquippableItems();
        if (strengthFromNonEquippableItems)
            additionalStrength += explorer.getStrengthFromNonEquippableItems();
        
        return additionalStrength;
    }
    
}
