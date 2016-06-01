package adventuregame.explorer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Explorers {
    private List<Explorer> availableExplorers;
    private List<Explorer> pickedExplorers;

    private int actualExplorer;
    
    public Explorers() {
        setExplorers();
    }
    
    public void setExplorers() {
        availableExplorers = new ArrayList<>();
        availableExplorers.add(new Filozof());
        availableExplorers.add(new Wojownik());
    }
    
    public void pickExplorers() {
        pickedExplorers = availableExplorers;
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
