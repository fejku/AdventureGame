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
        
        //TODO: Zamiana przedmiotu jeżeli posiadany tylko 1 
        int chosenItem = dialog.chooseOption("Wybierz przedmiot, który chcesz zamienić na złoto:", itemsNames);
        explorer.removeItem(chosenItem);
        explorer.gainGold();
        
        if (dialog.chooseYesNo("Zamienić kolejny przedmiot?")) {
            if (explorer.getItems().size() == 1) {
                explorer.removeItem(chosenItem);
                explorer.gainGold();
            } else if (explorer.getItems().size() > 1) {
                Action(board, explorer);
            }
        }
		
	}

}
