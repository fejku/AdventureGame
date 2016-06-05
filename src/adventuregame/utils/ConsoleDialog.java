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
            System.out.print(message + " (0-" + (nrChoices-1) + "): ");
            choice = input.nextInt();
        } while ((choice < 0) || (choice > nrChoices) && (nrChoices >= 0));
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
            message((i) + ". " + choices[i]);
        }
        return choose(choices.length);
    }

    @Override
    public boolean chooseYesNo(String message) {
        message(message);
        message("0. Tak");
        message("1. Nie");
        int choice = choose(2);
        if (choice == 0) 
            return true;
        else
            return false;
    }
}
