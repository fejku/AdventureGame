/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.explorer;

import adventuregame.board.fields.Field;

/**
 *
 * @author Fake
 */
public class Wojownik extends Explorer{

    public Wojownik() {
        super(5);
        setName("Wojownik");
        setStartingPosition(Field.GOSPODA);
    }
    
}
