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
}
