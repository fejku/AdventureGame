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
import adventuregame.cards.ACard;
import adventuregame.cards.enemy.Waz;
import adventuregame.cards.spells.Spell;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Board {
    private final List<Field> fields;
    private List<ACard> cards;
    private List<Spell> spells;
    private Equipments equipments;
    private final Dice dice;
    private final IDialog dialog;
            
    public Board(IDialog dialog, Dice dice) {
        this.dialog = dialog;
        this.dice = dice;
        this.fields = initFields();
        initNeighbors();     
        this.cards = initCards();
        this.spells = initSpells();
        equipments = new Equipments();
    }
    
    public Field getField(int fieldNr) {
    	return fields.get(fieldNr);
    }
    
    private List<Field> initFields() {
        List<Field> fields = new ArrayList<>();
        
        //OUTTER
        fields.add(new Gospoda());
        fields.add(new Rowniny());
        fields.add(new Puszcza());
        fields.add(new Rowniny());
        fields.add(new Wzgorza());
        fields.add(new Pola());
        
        fields.add(new Miasto());
        fields.add(new Pola());
        fields.add(new Puszcza());
        fields.add(new Rowniny());
        fields.add(new Skaly());
        fields.add(new Pola());
        
        fields.add(new Kapliczka());
        fields.add(new Wzgorza());
        fields.add(new Straznik());
        fields.add(new Puszcza());
        fields.add(new Cmentarz());
        fields.add(new Pola());
        
        fields.add(new Wioska());
        fields.add(new Pola());
        fields.add(new Las());
        fields.add(new Rowniny());
        fields.add(new Ruiny());
        fields.add(new Pola());

        //MIDDLE
        fields.add(new Pola());
        return fields;
    }
    
    private void initNeighbors() {
        int neighbor;
        //Set right Neighbor
        for (int i = 0; i < Field.FIELDS_OUTER_QUANTITY_TOP; i++) {
            neighbor = i + 1;
            if (neighbor == Field.FIELDS_OUTER_QUANTITY_TOP)
                neighbor = 0;
            fields.get(i).initNeighbor(Field.RIGHT, neighbor);
        }
        
        //Set left Neighbor
        for (int i = 0; i < Field.FIELDS_OUTER_QUANTITY_TOP; i++) {
            neighbor = i - 1;
            if (neighbor < 0)
                neighbor = Field.FIELDS_OUTER_QUANTITY_TOP - 1;
            fields.get(i).initNeighbor(Field.LEFT, neighbor);
        }        
    }
    
    public List<Integer> availableMoves(Explorer explorer) {
        List<Integer> moves = new ArrayList<>();
        int neighbour;
        int actualPosition = explorer.getActualPosition();
        
        moves.addAll(explorer.getNextMoves());

        int diceResult = 6;//dice.throwDice();
        
        //Left
        neighbour = fields.get(actualPosition).getNeighbor(Field.LEFT);
        for (int i = 1; i < diceResult; i++) {
            neighbour = fields.get(neighbour).getNeighbor(Field.LEFT);
        }
        if ((!moves.contains(neighbour)) && (neighbour != explorer.getActualPosition()))
            moves.add(neighbour);
        
        //Right
        neighbour = fields.get(actualPosition).getNeighbor(Field.RIGHT);
        for (int i = 1; i < diceResult; i++) {
            neighbour = fields.get(neighbour).getNeighbor(Field.RIGHT);
        }
        if ((!moves.contains(neighbour)) && (neighbour != explorer.getActualPosition()))
            moves.add(neighbour);
        
        return moves;
    }
    
    public void fieldAction(Explorers explorers) {
        fields.get(explorers.getActualExplorer().getActualPosition()).action(this, explorers);
    }
    
    public boolean isCardOnField(int fieldNr) {
        return fields.get(fieldNr).isCardOnField();
    }
    
    public List<ACard> initCards() {   
        List<ACard> cards = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cards.add(new Waz());
        }
        return cards;
    }
    
    public ACard getCardFromDeck() {
        ACard card;
        card = cards.get(0);
        cards.remove(0);
        return card;
    }
    
    public List<ACard> getCardFromDeck(int amount) {
        List<ACard> cardsFromDeck = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            cardsFromDeck.add(getCardFromDeck());
        }
        return cardsFromDeck;
    }
    
    public Dice getDice() {
        return dice;
    }
    
    public IDialog getDialog() {
        return dialog;
    }
    
    public List<Spell> initSpells() {
        List<Spell> spells = new ArrayList<>();
        return spells;
    }
    
    public Spell getSpellFromDeck() {
        Spell spell = spells.get(0);
        spells.remove(0);
        return spell;
    }
       
    public Equipments getEquipment() {
    	return equipments;
    }
}
