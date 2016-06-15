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
    
    public FieldGetCard(String name, int amountCardsOnField) {
        super(name);
        this.amountCardsOnField = amountCardsOnField;
    }

    @Override
    public void action(Board board, Explorers explorers) {
        //Sprawdz ile kart dobrać
        int amountMissingCards = amountCardsOnField - getCards().size();
        //Dodanie brakującej ilości kart do pola
        getCards().addAll(board.getCardFromDeck(amountMissingCards));
        
        Iterator<ACard> itCards = getCards().iterator();
        while (itCards.hasNext()) {
            ACard card = itCards.next();
            //Sprawdzenie czy są karty z priorytetem 1
            if (card.getPriority() == 1)
                //Akcja karty
                card.action(board, explorers);
            if (!card.isStaying())
                itCards.remove(); 
            if (card.isInterupting())
                return;
        }
        
//        for(ACard card : getCards()) {
//            //Sprawdzenie czy są karty z priorytetem 1
//            if (card.getPriority() == 1)
//                //Akcja karty
//                card.action(board, explorers);
//            if (!card.isStaying())
//                getCards().remove(card);
//        }
        //Przerwanie akcji??
        
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
        
        
        
        
//        for (int i = 0; i < getCards().size(); i++) {
//            getCards().get(i).Action(board, explorers);
//        }
    }
    
}
