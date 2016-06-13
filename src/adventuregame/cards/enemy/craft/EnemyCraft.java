/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.cards.enemy.craft;

import adventuregame.cards.enemy.Enemy;

/**
 *
 * @author Fake
 */
public abstract class EnemyCraft extends Enemy {
    
    public EnemyCraft(String name, int craft) {
        super(name, 3, craft);
    }
    
}
