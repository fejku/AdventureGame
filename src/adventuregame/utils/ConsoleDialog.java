/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.utils;

import java.util.Scanner;

/**
 *
 * @author Fake
 */
public class ConsoleDialog implements IDialog {

    Scanner input = new Scanner(System.in);
    
    @Override
    public void message(String message) {
        System.out.println(message);
    }
    
    @Override
    public int choose(String message, int nrChoices) {
        int choice;
        do {
            System.out.print(message + " (1-" + nrChoices + "): ");
            choice = input.nextInt();
        } while ((choice < 1) || (choice > nrChoices) && (nrChoices > 0));
        return choice;
    }

    @Override
    public int choose(int nrChoices) {
        return choose("Twój wybór", nrChoices);
    }

    @Override
    public int chooseOption(String message, String[] choices) {
        message(message);
        for (int i = 0; i < choices.length; i++) {
            message((i+1) + ". " + choices[i]);
        }
        return choose(choices.length);
    }
}
