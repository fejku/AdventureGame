package adventuregame.board.fields.outer;

import adventuregame.board.Board;
import adventuregame.board.fields.Field;
import adventuregame.board.fields.outer.miasto.Alchemik;
import adventuregame.board.fields.outer.miasto.Cyrulik;
import adventuregame.board.fields.outer.miasto.Czarodziejka;
import adventuregame.board.fields.outer.miasto.ICitizen;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fake
 */
public class Miasto extends OuterField {
    public Miasto() {
        super("Miasto");
    }

    @Override
    public void action(Board board, Explorers explorers) {    	
    	List<ICitizen> citizens = initListWithValidCitizens(explorers.getActualExplorer());

    	String[] citizensNames = new String[citizens.size()];
    	for (int i = 0; i < citizens.size(); i++)
            citizensNames[i] = citizens.get(i).getName();
        
    	int choice = board.getDialog().chooseOption("Możesz odwiedzić:", citizensNames);
    	citizens.get(choice).action(board, explorers.getActualExplorer());
    }
    
    public List<ICitizen> initListWithValidCitizens(Explorer explorer) {
    	List<ICitizen> citizens = new ArrayList<>();
    	ICitizen cyrulik = new Cyrulik();
    	if (cyrulik.isValid(explorer)) 
            citizens.add(cyrulik);
    	ICitizen alchemik = new Alchemik();
    	if (alchemik.isValid(explorer)) 
            citizens.add(alchemik);
    	ICitizen czarodziejka = new Czarodziejka();
    	citizens.add(czarodziejka);
    	
    	return citizens;
    }
}
