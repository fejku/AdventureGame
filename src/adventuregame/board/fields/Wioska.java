/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import java.util.ArrayList;
import java.util.List;

import adventuregame.board.Board;
import adventuregame.board.fields.miasto.ICitizen;
import adventuregame.board.fields.miasto.Kowal;
import adventuregame.board.fields.miasto.Lekarz;
import adventuregame.board.fields.miasto.Mystic;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Wioska extends Field{

    public Wioska() {
        super("Wioska");
    }

    @Override
    public void action(Board board, Explorers explorers) {
    	List<ICitizen> citizens = initListWithValidCitizens(explorers.getActualExplorer());

    	String[] citizensNames = new String[citizens.size()];
    	for (int i = 0; i < citizens.size(); i++) {
			citizensNames[i] = citizens.get(i).getName();
		}
    	int choice = board.getDialog().chooseOption("Możesz odwiedzić:", citizensNames);
    	citizens.get(choice).Action(board, explorers.getActualExplorer());
    }
    
    public List<ICitizen> initListWithValidCitizens(Explorer explorer) {
    	List<ICitizen> citizens = new ArrayList<>();
    	ICitizen lekarz = new Lekarz();
    	if (lekarz.isValid(explorer)) 
    		citizens.add(lekarz);
    	ICitizen kowal = new Kowal();
    	if (kowal.isValid(explorer)) 
    		citizens.add(kowal);
    	ICitizen mystic = new Mystic();
    	citizens.add(mystic);
    	
    	return citizens;
    }
    
}
