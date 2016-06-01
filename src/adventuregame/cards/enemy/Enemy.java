/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.cards.enemy;

import adventuregame.board.Board;
import adventuregame.cards.Card;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public abstract class Enemy extends Card{
    
    private int strength;

    public Enemy(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
    
    @Override
    public void Action(Board board, Explorers explorers) {
        Explorer actExp = explorers.getActualExplorer();
        
        System.out.println("Przeciwnik " + getName() + " siła: " + getStrength());
        int foeStrenght = getStrength() + board.getDice().throwDice();
        System.out.println("Sila przeciwnika po rzucie: "+foeStrenght);
        System.out.println(actExp.writeStats());
        int explorerStrenght = actExp.getStrength() +
                board.getDice().throwDice();
        System.out.println("Sila poszukiwacza po rzucie: " + explorerStrenght);
        if(explorerStrenght>foeStrenght) {
            //Usunięcie karty z pola
            board.getField(actExp.getActualPosition()).removeCardFromField(this);
            //Dodanie karty potwora do pokonanych
            actExp.addCreature(this);
            System.out.println("Poszukiwacz wygral!");
        } else if(explorerStrenght==foeStrenght)
            //Nic się nie dzieje
            System.out.println("Remis");
        else {
            //Strata punktu wytrzymałości
            System.out.println("Przeciwnik wygral :(");
            if (actExp.subtractLife())
                //Usun gracza
                if (explorers.removeActualExplorer())
                    //koniec gry albo wybranie kolejnej postaci
                    {}
            System.out.println(actExp.writeStats());
        }
    }
}
