package adventuregame.board;

import adventuregame.board.fields.Cmentarz;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.Gospoda;
import adventuregame.board.fields.Kapliczka;
import adventuregame.board.fields.Las;
import adventuregame.board.fields.Miasto;
import adventuregame.board.fields.Pola;
import adventuregame.board.fields.Puszcza;
import adventuregame.board.fields.Rowniny;
import adventuregame.board.fields.Ruiny;
import adventuregame.board.fields.Skaly;
import adventuregame.board.fields.Straznik;
import adventuregame.board.fields.Wioska;
import adventuregame.board.fields.Wzgorza;
import adventuregame.cards.Card;
import adventuregame.cards.MieszekZlota;
import adventuregame.cards.creature.Waz;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.Dice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Board {
    private List<Field> fields;
    private List<Card> cards;
    private Dice dice;
            
    public Board(Dice dice) {
        this.dice = dice;
        setFields();
        setNeighbors();
        
        setCards();
    }
    
    public Field getField(int fieldNr) {
    	return fields.get(fieldNr);
    }
    
    private void setFields() {
        fields = new ArrayList<>();
        //0
        fields.add(new Gospoda());
        fields.add(new Rowniny());
        fields.add(new Puszcza());
        fields.add(new Rowniny());
        fields.add(new Wzgorza());
        fields.add(new Pola());
        //6
        fields.add(new Miasto());
        fields.add(new Pola());
        fields.add(new Puszcza());
        fields.add(new Rowniny());
        fields.add(new Skaly());
        fields.add(new Pola());
        //12
        fields.add(new Kapliczka());
        fields.add(new Wzgorza());
        fields.add(new Straznik());
        fields.add(new Puszcza());
        fields.add(new Cmentarz());
        fields.add(new Pola());
        //18
        fields.add(new Wioska());
        fields.add(new Pola());
        fields.add(new Las());
        fields.add(new Rowniny());
        fields.add(new Ruiny());
        fields.add(new Pola());
    }
    
    private void setNeighbors() {
        int neighbor;
        //Set right Neighbor
        for (int i = Field.FIELDS_OUTER_QUANTITY_BOTTOM; i < Field.FIELDS_OUTER_QUANTITY_TOP; i++) {
            neighbor = i + 1;
            if (neighbor == Field.FIELDS_OUTER_QUANTITY_TOP)
                neighbor = Field.FIELDS_OUTER_QUANTITY_BOTTOM;
            fields.get(i).setNeighbor(Field.RIGHT, neighbor);
        }
        
        //Set left Neighbor
        for (int i = Field.FIELDS_OUTER_QUANTITY_BOTTOM; i < Field.FIELDS_OUTER_QUANTITY_TOP; i++) {
            neighbor = i - 1;
            if (neighbor < Field.FIELDS_OUTER_QUANTITY_BOTTOM)
                neighbor = Field.FIELDS_OUTER_QUANTITY_TOP - 1;
            fields.get(i).setNeighbor(Field.LEFT, neighbor);
        }        
    }
    
    public List<Integer> availableMoves(int actualPosition) {
        List<Integer> moves = new ArrayList<>();
        int neighbour;
        int diceResult = 5;//dice.throwDice();
        
        //Left
        neighbour = fields.get(actualPosition).getNeighbor(Field.LEFT);
        for (int i = 1; i < diceResult; i++) {
            neighbour = fields.get(neighbour).getNeighbor(Field.LEFT);
        }
        moves.add(neighbour);
        
        //Right
        neighbour = fields.get(actualPosition).getNeighbor(Field.RIGHT);
        for (int i = 1; i < diceResult; i++) {
            neighbour = fields.get(neighbour).getNeighbor(Field.RIGHT);
        }
        moves.add(neighbour);
        
        return moves;
    }
    
    public void fieldAction(Explorers explorers) {
        fields.get(explorers.getActualExplorer().getActualPosition()).Action(this, explorers);
    }
    
    public boolean isCardOnField(int fieldNr) {
        return fields.get(fieldNr).isCardOnField();
    }
    
    public void setCards() {   
        cards = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cards.add(new Waz());
        }
    }
    
    public Card getCardFromDeck() {
        Card card;
        card = cards.get(0);
        cards.remove(0);
        return card;
    }
    
    public Dice getDice() {
        return dice;
    }
}
