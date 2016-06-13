/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.cards.enemy.strength;

import adventuregame.cards.enemy.Enemy;

/**
 *
 * @author Fake
 */
public abstract class EnemyStrenght extends Enemy {
    
    public EnemyStrenght(String name, int strength) {
        super(name, 2, strength);
    }
    
}
