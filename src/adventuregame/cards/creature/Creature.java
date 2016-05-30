/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.cards.creature;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Creature extends Card{
    
    private int strenght;

    public Creature(String name, int strength) {
        super(name);
    }

    public int getStrenght() {
        return strenght;
    }
    
    @Override
    public void Action(Board board, Explorers explorers) {
        System.out.println("Przeciwnik " + getName() + " siła: " + getStrenght());
        int foeStrenght = getStrenght() + board.getDice().throwDice();
        System.out.println("Sila przeciwnika po rzucie: "+foeStrenght);
        System.out.println(explorers.getActualExplorer().writeStats());
        int explorerStrenght = explorers.getActualExplorer().getStrength() +
                board.getDice().throwDice();
        System.out.println("Sila poszukiwacza po rzucie: " + explorerStrenght);
        if(explorerStrenght>foeStrenght) {
            //Dodanie karty potwora do pokonanych
            explorers.getActualExplorer().addCreature(this);
            System.out.println("Poszukiwacz wygral!");
        } else if(explorerStrenght==foeStrenght)
            //Nic się nie dzieje
            System.out.println("Remis");
        else {
            //Strata punktu wytrzymałości
            System.out.println("Przeciwnik wygral :(");
            if (explorers.getActualExplorer().subtractLife())
                //Usun gracza
                if (explorers.removeActualExplorer())
                    //koniec gry albo wybranie kolejnej postaci
                    {}
            System.out.println(explorers.getActualExplorer().writeStats());
        }
    }
}
