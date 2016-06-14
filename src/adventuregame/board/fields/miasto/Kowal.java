package adventuregame.board.fields.miasto;

import java.util.ArrayList;
import java.util.List;

import adventuregame.board.Board;
import adventuregame.cards.item.Helm;
import adventuregame.cards.item.Item;
import adventuregame.cards.item.Tarcza;
import adventuregame.cards.item.Zbroja;
import adventuregame.cards.item.weapon.Miecz;
import adventuregame.cards.item.weapon.Topor;
import adventuregame.explorer.Explorer;

public class Kowal extends ACitizen {

    public Kowal() {
        super("Kowal");
    }

    @Override
    public boolean isValid(Explorer explorer) {
        if (explorer.getGold() >= 2)
            return true;
        else
            return false;
    }

    //BLACKSMITH: The Blacksmith sells the following objects (if available):
    //Helmet - 2G Sword - 2G Axe - 2G Shield - 3G Armour - 4G
    @Override
    public void action(Board board, Explorer explorer) {
        List<Item> availableEquipments = new ArrayList<>();
        if (board.getEquipment().isEquipemntInDeck(Helm.class) 
                && (explorer.getGold() >= 2))
            availableEquipments.add(new Helm());
        if (board.getEquipment().isEquipemntInDeck(Miecz.class) 
                && (explorer.getGold() >= 2))
            availableEquipments.add(new Miecz());
        if (board.getEquipment().isEquipemntInDeck(Topor.class) 
                && (explorer.getGold() >= 2))
            availableEquipments.add(new Topor());
        if (board.getEquipment().isEquipemntInDeck(Tarcza.class) 
                && (explorer.getGold() >= 3))		
            availableEquipments.add(new Tarcza());
        if (board.getEquipment().isEquipemntInDeck(Zbroja.class) 
                && (explorer.getGold() >= 4))
            availableEquipments.add(new Zbroja());

        String[] availableEquipmentsName = new String[availableEquipments.size()];
        for (int i = 0; i < availableEquipmentsName.length; i++) {
            availableEquipmentsName[i] = availableEquipments.get(i).getName() 
                    + " - " + availableEquipments.get(i).getCostInTown() 
                    + " mieszki złota."; 
        }

        int choice = board.getDialog().chooseOption("Co chcesz kupić?", availableEquipmentsName);
        explorer.loseGold(availableEquipments.get(choice).getCostInTown());
        explorer.gainItem(board.getEquipment().removeEquipmentFromDeck(availableEquipments.get(choice).getClass()));
    }

}
