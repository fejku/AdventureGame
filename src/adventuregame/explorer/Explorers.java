package adventuregame.explorer;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.Field.Region;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Explorers {
    private final List<Explorer> allExplorers;
    private List<Explorer> pickedExplorers;

    private int actualExplorer;
    
    public Explorers() {
        this.allExplorers = initExplorers();
    }
    
    public List<Explorer> initExplorers() {
        List<Explorer> explorers = new ArrayList<>();
        explorers.add(new Test("Test1", 2, 2, Field.GOSPODA, ExplorerCharacter.DOBRY));
        explorers.add(new Test("Test2", 2, 2, Field.GOSPODA, ExplorerCharacter.ZLY));
        explorers.add(new Test("Test3", 2, 2, Field.GOSPODA, ExplorerCharacter.DOBRY));
        explorers.add(new Test("Test4", 2, 2, Field.GOSPODA, ExplorerCharacter.ZLY));
        explorers.add(new Test("Test5", 2, 2, Field.GOSPODA, ExplorerCharacter.ZLY));
        explorers.add(new Test("Test6", 2, 2, Field.GOSPODA, ExplorerCharacter.DOBRY));
        //explorers.add(new Filozof());
        //explorers.add(new Wojownik());
        return explorers;
    }
    
    public void pickExplorers() {
        //TODO: Zmienić to na losowanie i wybranie Poszukiwacza
        pickedExplorers = allExplorers;
        actualExplorer = 0;
    }
    
    public Explorer getActualExplorer() {
        return pickedExplorers.get(actualExplorer);
    }
    
    public void nextExplorerTurn() {
        actualExplorer++;
        if (actualExplorer >= pickedExplorers.size()) {
            actualExplorer = 0;
        }
    }
    
    public boolean removeActualExplorer() {
        pickedExplorers.remove(actualExplorer);
        if (pickedExplorers.size() > 1)
            return false;
        else
            return true;
    }
    
    public List<Explorer> getOtherExplorersOnField(int fieldNr) {
    	List<Explorer> otherExplorersOnField = new ArrayList<>();
    	for (int i = 0; i < pickedExplorers.size(); i++) {
            if ((pickedExplorers.get(i).getActualPosition() == fieldNr) 
                    && (i != actualExplorer))
                otherExplorersOnField.add(pickedExplorers.get(i));
        }
    	return otherExplorersOnField;
    }
    
    public List<Explorer> getExplorers() {
        return pickedExplorers;
    }
    
    public List<Explorer> getExplorersFromActual() {
        List<Explorer> explorersList = pickedExplorers;
        Collections.rotate(explorersList, explorersList.size() - actualExplorer);
        
        return explorersList;
    }
    
    public List<Explorer> getExplorersWithOrder(boolean isOriginalOrder) {
        if (isOriginalOrder)
            return pickedExplorers;
        else
            return getExplorersFromActual();
    }
    
    public List<Explorer> getExplorersByCharacter(ExplorerCharacter character, boolean isOriginalOrder) {
        List<Explorer> explorersWithCharacter = new ArrayList<>();
        for (Explorer explorer : getExplorersWithOrder(isOriginalOrder))
            if (explorer.getCharacter() == character)
                explorersWithCharacter.add(explorer);
        
        return explorersWithCharacter;
    }
    
    public List<Explorer> getExplorersHavingGold(boolean isOriginalOrder) {
        List<Explorer> explorersWithGold = new ArrayList<>();;
        for (Explorer explorer : getExplorersWithOrder(isOriginalOrder))
            if (explorer.getGold() > 0)
                explorersWithGold.add(explorer);
        
        return explorersWithGold;
    }
    
    public List<Explorer> getExplorersFromRegion(Region region, Board board, boolean isOriginalOrder) {
        List<Explorer> explorersWithGold = new ArrayList<>();;
        for (Explorer explorer : getExplorersWithOrder(isOriginalOrder))
            if (board.getField(explorer.getActualPosition()).getRegion() == region)
                explorersWithGold.add(explorer);
        
        return explorersWithGold;
    }
    
    public int getActualExplorerNumber() {
        return actualExplorer;
    }
}
