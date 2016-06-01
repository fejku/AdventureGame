/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class Miasto extends Field{
    public Miasto() {
        super("Miasto");
    }

    @Override
    public void Action(Board board, Explorers explorers) {
        System.out.println("Możesz odwiedzić");
        System.out.println("1: Cyrulika");
        System.out.println("2: Alchemika");
        System.out.println("3: Czarodziejkę");
        System.out.print("Twój wybór:");
        int choice = Integer.parseInt(System.console().readLine());
        switch(choice) {
            case 1:
                    //Odzyskujesz do 2 punktów życia płacąc za każdy z nich 1 sztukę złota
                    System.out.print("Ile życia chcesz odzyskać? (1-2):");
                    int amount = Integer.parseInt(System.console().readLine());
                    explorers.getActualExplorer().renewLife(amount);
                    explorers.getActualExplorer().subGold(amount);
                    break;
        }
        switch (board.getDice().throwDice()) {
            
        }
    }
    
    
}
