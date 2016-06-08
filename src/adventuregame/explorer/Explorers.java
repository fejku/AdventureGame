package adventuregame.explorer;

import adventuregame.board.fields.Field;
import java.util.ArrayList;
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
        explorers.add(new Test("Test", 2, 2, Field.MIASTO, ExplorerCharacter.DOBRY));
        explorers.add(new Filozof());
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
}
