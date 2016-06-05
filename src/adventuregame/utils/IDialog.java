/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.utils;

/**
 *
 * @author Fake
 */
public interface IDialog {
    public void message(String message);
    public int choose(int nrChoices);
    public int choose(String message, int nrChoices);
    public int chooseOption(String message, String[] choices);
    public boolean chooseYesNo(String message);
}
