package adventuregame.board.fields.miasto;

import java.util.List;

import adventuregame.board.Board;
import adventuregame.cards.item.ACardObject;
import adventuregame.explorer.Explorer;
import adventuregame.utils.IDialog;

public class Alchemik extends ACitizen {

    public Alchemik() {
        super("Alchemik");
    }

    @Override
    public boolean isValid(Explorer explorer) {
        if (explorer.getItems().size() > 0)
            return true;
        else
            return false;
    }

    /**
     * Możesz zamienić swoje Przedmioty w złoto. 
     * Za każdą odrzuconą kartę Przedmiotu, otrzymujesz 1 sztukę złota.
     * @param board
     * @param explorer Aktualny Poszukiwacz
     */
    @Override
    public void Action(Board board, Explorer explorer) {
        IDialog dialog = board.getDialog();
        List<ACardObject> items = explorer.getItems();
        String[] itemsNames = new String[items.size()];

        for (int i = 0; i < items.size(); i++) {
            itemsNames[i] = items.get(i).getName();
        }

        if (items.size() == 1) {
            dialog.message("Zamieniono " + items.get(0).getName() + " na 1 mieszek złota.");
            explorer.removeItem(0);
            explorer.gainGold();
        } else {
            int chosenItem = dialog.chooseOption("Wybierz przedmiot, który chcesz zamienić na złoto:", itemsNames);
            dialog.message("Zamieniono " + items.get(chosenItem).getName() + " na 1 mieszek złota.");
            explorer.removeItem(chosenItem);
            explorer.gainGold();

            if (dialog.chooseYesNo("Zamienić kolejny przedmiot?"))
                Action(board, explorer);
        }
    }
}
