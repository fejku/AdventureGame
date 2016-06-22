package adventuregame.board;

import java.util.ArrayList;
import java.util.List;

import adventuregame.board.fields.Field;
import adventuregame.board.fields.Field.Region;
import adventuregame.board.fields.outer.Cmentarz;
import adventuregame.board.fields.outer.Gospoda;
import adventuregame.board.fields.outer.Kapliczka;
import adventuregame.board.fields.outer.Las;
import adventuregame.board.fields.outer.Miasto;
import adventuregame.board.fields.outer.Pola;
import adventuregame.board.fields.outer.Puszcza;
import adventuregame.board.fields.outer.Rowniny;
import adventuregame.board.fields.outer.Ruiny;
import adventuregame.board.fields.outer.Skaly;
import adventuregame.board.fields.outer.Straznik;
import adventuregame.board.fields.outer.Wioska;
import adventuregame.board.fields.outer.Wzgorza;
import adventuregame.cards.ACard;
import adventuregame.cards.events.Patrol;
import adventuregame.cards.events.Wulkan;
import adventuregame.cards.events.ZlaCiemnosc;
import adventuregame.cards.spells.Spell;
import adventuregame.cards.stranger.Magik;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.utils.Dice;
import adventuregame.utils.IDialog;

/**
 *
 * @author Fake
 */
public class Board {
	
    public enum GameState {
        CHECK_LOST_TURN,
        BEFORE_ROLL,
        MOVEMENT_CHOICE,
        BEFORE_FIELD_ACTION,
        POST_MOVEMENT,
        TURN_END,        
        GAME_END
    }
    
    private final List<Field> fields;
    private List<ACard> cards;
    private List<ACard> usedAdventureCards;
    private List<Spell> spells;
    private List<Spell> usedSpells;
    private Equipments equipments;
    private final Dice dice;
    private final IDialog dialog;
    private GameState gameState;
            
    public Board(IDialog dialog, Dice dice) {
        this.dialog = dialog;
        this.dice = dice;
        this.gameState = GameState.CHECK_LOST_TURN;
        this.fields = initFields();
        initNeighbors();     
        this.cards = initCards();
        this.usedAdventureCards = new ArrayList<>();
        this.spells = initSpells();
        this.usedSpells = new ArrayList<>();
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

        int diceResult = 1;//dice.throwDice();
        
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
        
        cards.add(new Wulkan());
        cards.add(new Magik());        
        cards.add(new Patrol());
        cards.add(new ZlaCiemnosc());
        
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
    
    public GameState getGameState() {
        return gameState;
    }
    
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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
    
    public List<Spell> getUsedSpells() {
        return usedSpells;
    }
    
    public List<ACard> getUsedAdventureCards() {
        return usedAdventureCards;
    }
    
    public List<Field> getFieldsByRegion(Region region) {
        List<Field> fieldsInRegion = new ArrayList<>();
        for (Field field : fields)
            if (field.getRegion() == region)
                fieldsInRegion.add(field);
        
        return fieldsInRegion;
    }
}
