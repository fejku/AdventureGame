package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.board.fields.IField;
import adventuregame.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public abstract class Field implements IField {
    
    public static int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    public static int FIELDS_OUTER_QUANTITY_BOTTOM = 0, FIELDS_OUTER_QUANTITY_TOP = 24;
    public static int GOSPODA = 0, MIASTO = 6, SKALY = 10, KAPLICZKA = 12, STRAZNIK = 14, 
            CMENTARZ = 16, WIOSKA = 18, LAS = 20, RUINY = 22;
    
    private String name;
    
    private int fieldNr;
    private int[] neighbors;
    
    private List<Card> cards;
   
    public Field(String name) {
        this.name = name;
        neighbors = new int[4];
        cards = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    protected void setName(String name) {
        this.name = name;
    }
    
    public int getNeighbor(int location) {
        return neighbors[location];
    }
    
    public void setNeighbor(int location, int neighbor) {
        neighbors[location] = neighbor;
    }    
    
    public List<Card> getCards() {
        return cards;
    }
    
    public boolean isCardOnField() {
        if (cards.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
