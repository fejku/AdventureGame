/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.utils;

import java.util.Random;

/**
 *
 * @author Fake
 */
public class Dice {
    private Random r;
    
    public Dice() {
        r = new Random();
    }
    
    public int throwDice() {
        return throwDice(6);
    }
    
    public int throwDice(int sides) {
        return r.nextInt(sides) + 1;
    }
}
