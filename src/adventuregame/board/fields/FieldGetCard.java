package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.cards.enemy.Enemy;
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
               
        List<Enemy> enemyCards = new ArrayList<>();
        for (ACard enemyCard : getCards()) {
            if (enemyCard.getPriority() == 2) {
                enemyCards.add((Enemy)enemyCard);
                ((Enemy)enemyCard).actionBeforeFight(board, explorers);
            }
        }
        if (!enemyCards.isEmpty()) {
            switch (explorers.getActualExplorer().fight(board, explorers.getActualExplorer(), enemyCards,
                    isStrengthFromFriends(), isStrengthFromEquippableItems(), isStrengthFromNonEquippableItems())) {
                case WIN:
                    Iterator<ACard> cardsOnField = getCards().iterator();
                    while (cardsOnField.hasNext()) {
                        ACard cardOnField = cardsOnField.next();
                        if (cardOnField.getPriority() == 2) {
                            explorers.getActualExplorer().gainTrophy((Enemy)cardOnField);
                            cardsOnField.remove();
                        }
                    }
                    break;
                case TIE:
                    //Połóż pozostałe karty na polu
                    for (ACard cardsFromField : getCards())
                        cardsFromField.setOnField(true);
                    //koniec tury
                    board.setGameState(Board.GameState.TURN_END);                    
                    return;
                default:
                    //Połóż pozostałe karty na polu
                    for (ACard cardsFromField : getCards())
                        cardsFromField.setOnField(true);                    
                    //TODO: if armor throw for armor
                    //traci 1 punkt życia
                    explorers.getActualExplorer().loseLife(board);                    
                    //koniec tury
                    board.setGameState(Board.GameState.TURN_END);
                    return;
            }
        }
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
