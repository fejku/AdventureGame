package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.cards.ACard;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.FightResult;
import adventuregame.explorer.FightType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public abstract class Field {
    
    public static final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    public static final int FIELDS_OUTER_QUANTITY_TOP = 24, FIELDS_MIDDLE_QUANTITY_TOP = 40, FIELDS_INNER_QUANTITY_TOP = 48;
    public static final int GOSPODA = 0, MIASTO = 6, SKALY = 10, KAPLICZKA = 12, STRAZNIK = 14, 
            CMENTARZ = 16, WIOSKA = 18, LAS = 20, RUINY = 22,
            SWIATYNIA = 24;
    
    private final String name;    
    private final int[] neighbors;
    
    private List<ACard> cards;
   
    public Field(String name) {
        this.name = name;
        neighbors = new int[4];
        cards = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public int getNeighbor(int location) {
        return neighbors[location];
    }
    
    public void initNeighbor(int location, int neighbor) {
        neighbors[location] = neighbor;
    }    
    
    public List<ACard> getCards() {
        return cards;
    }
    
    public void removeCardFromField(ACard card) {
    	cards.remove(card);
    }
    
    public boolean isCardOnField() {
        if (cards.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void fightWithoutCard(Board board, Explorer explorer, FightType type, int amount) {
        FightResult fightResult;
        
        fightResult = explorer.fight(board, type, amount);
        if (fightResult == FightResult.LOSE) {
            explorer.loseLife();
        }
    }
    
    public abstract void action(Board board, Explorers explorers);
//    	boolean meetOtherExplorer = false;
//        
//    	Explorer actualExplorer = explorers.getActualExplorer();
//    	List<Explorer> otherExplorersOnField = explorers.getOtherExplorersOnField(actualExplorer.getActualPosition());
//    	
//    	if (otherExplorersOnField.size() > 0) {
//            System.out.println("Wybierz akcję:\n1:Spotkanie z Poszukiwaczem\n2:Badaj obszar");
//            int choice = Integer.parseInt(System.console().readLine());
//            if (choice == 1)
//                meetOtherExplorer = true;
//    	}
//    	
//    	if (meetOtherExplorer) {
//     	Explorer otherExplorer;
//           if(otherExplorersOnField.size() > 1) {
//                System.out.println("Wybierz z którym Poszukiwaczem chcesz się spotkać:");
//                for (int i = 0; i < otherExplorersOnField.size(); i++)
//                    System.out.println(i+ ": " + otherExplorersOnField.get(i).getName());
//                int choice = Integer.parseInt(System.console().readLine());
//                otherExplorer = otherExplorersOnField.get(choice);
//            } else
//                otherExplorer = otherExplorersOnField.get(0);
//            //TODO: Spotkanie z innym Poszukiwaczem
//    	} else {
//            //TODO: Sprawdzenie czy na polu leżą karty
//            
//            
//            //FieldAction(board, explorers);
//        	//TODO: Dociągnięcie odpowiedniej ilości kart i położenie na polu
//        	//TODO: Zastosowanie się do kart leżących na obszarze
//        	//TODO: Zastosowanie do polecenia znajdującego się na obszarze
//    	}
//    }
    
    //public abstract void FieldAction(Board board, Explorers explorers);
}
