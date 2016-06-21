package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Fake
 */
public abstract class FieldGetCard extends Field {

    private final int amountCardsOnField;
    
    public FieldGetCard(String name, Region region, int amountCardsOnField) {
        super(name, region);
        this.amountCardsOnField = amountCardsOnField;
    }

    @Override
    public void action(Board board, Explorers explorers) {
        //Sprawdz ile kart dobrać
        int amountMissingCards = amountCardsOnField - getCards().size();
        //Karty jeszcze nie rozpatrzone np. Trzesienie ziemi nie może ich jeszcze zdjąć
        List<ACard> newCards = board.getCardFromDeck(amountMissingCards);
        //Wszystkie karty na tym polu
        List<ACard> allCards = new ArrayList<>(); 
		allCards.addAll(getCards());
        allCards.addAll(newCards);
        
        Iterator<ACard> iteratorCards = allCards.iterator();
        while(iteratorCards.hasNext()) {
        	ACard card = iteratorCards.next();
            //Sprawdzenie czy są karty z priorytetem 1
            if (card.getPriority() == 1) {
                //Akcja karty
                card.action(board, explorers);
	            //Czy karta zostaje na polu
	            if (card.isStaying())
	            	getCards().add(card);
	            else
	            	iteratorCards.remove();
	            //Czy karta kończy turę
	            if (card.isInterupting()) { 
	            	//Dodanie pozostałych nie rozpatrzonych kart do pola
	            	getCards().clear();
	            	getCards().addAll(allCards);
	            	return;
	            }
            }
        }
               
        List<ACard> enemys = new ArrayList<>();        
        for(ACard card : getCards()) {
            if (card.getPriority() == 2)
                enemys.add(card);
        }
        if (enemys.size() > 0) {
            FightResult fr = explorers.getActualExplorer().fight(enemys);
        }
        
        //Sprawdzenie czy są karty z 2
        //Walka
        //Sprawdzenie czy są karty z 3
        //walka
        //Sprawdzenie czy są karty z 4
        //wziecie itemu/przyjaciela
        //Sprawdzenie czy są karty z 5
        //akcja karty
    }
    
}
