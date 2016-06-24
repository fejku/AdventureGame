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

    public FieldGetCard(String name, Region region, int amountDrawingCards) {
        super(name, region, amountDrawingCards);
    }

    @Override
    public void action(Board board, Explorers explorers) {
        Iterator<ACard> eventCards = getCards().iterator();
        while(eventCards.hasNext()) {
            ACard eventCard = eventCards.next();
            //Sprawdzenie czy są karty z priorytetem 1
            if (eventCard.getPriority() == 1) {
                //Akcja karty
                eventCard.action(board, explorers);
                    if (eventCard.isStaying())
                        eventCard.setOnField(true);
                    else
                        eventCards.remove();
	            //Czy karta kończy turę
	            if (eventCard.isInterupting()) { 
                        //Zaznacz wszystkie karty jako położone na polu
                        for (ACard cardsFromField : getCards())
                            cardsFromField.setOnField(true);
                        //Zakończ akcję pola
	            	return;
	            }
            }
        }
               
        List<ACard> enemyCards = new ArrayList<>();
        for (ACard enemyCard : getCards()) {
            if (enemyCard.getPriority() == 2)
                enemyCards.add(enemyCard);
        }
        if (enemyCards.size() > 0)
            explorers.getActualExplorer().fight(enemyCards, explorers.getActualExplorer());
        
//        List<ACard> enemys = new ArrayList<>();        
//        for(ACard card : getCards()) {
//            if (card.getPriority() == 2)
//                enemys.add(card);
//        }
//        if (enemys.size() > 0) {
//            FightResult fr = explorers.getActualExplorer().fight(enemys);
//        }
        
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
