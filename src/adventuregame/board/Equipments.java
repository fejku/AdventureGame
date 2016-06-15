package adventuregame.board;

import java.util.ArrayList;
import java.util.List;

import adventuregame.cards.item.Item;
import adventuregame.cards.item.armour.Helm;
import adventuregame.cards.item.armour.Tarcza;
import adventuregame.cards.item.weapon.Topor;
import adventuregame.cards.item.armour.Zbroja;
import adventuregame.cards.item.weapon.Miecz;

public class Equipments {
    private List<Item> equipments;

    public Equipments() {
        equipments = initEquipments();
    }
	
    private List<Item> initEquipments() {
    	List<Item> equipment = new ArrayList<>();
    	
    	equipment.addAll(addEquipment(new Miecz()));
    	equipment.addAll(addEquipment(new Helm()));
    	equipment.addAll(addEquipment(new Topor()));
    	equipment.addAll(addEquipment(new Tarcza()));
    	equipment.addAll(addEquipment(new Zbroja()));
    	
    	return equipment;
    }
    
    public List<Item> getEquipments() {
    	return equipments;
    }
    
    public int amountOfEquipmentInDeck(Class<?> equipmentType) {
    	int amount = 0;
    	for (Item equipment: equipments) {
            if (equipmentType.isInstance(equipment)) {
                amount++;
            }
        }
    	return amount;
    }
    
    public boolean isEquipemntInDeck(Class<?> equipmentType) {
    	return (amountOfEquipmentInDeck(equipmentType) > 0);
    }
    
    public Item removeEquipmentFromDeck(Class<?> equipmentType) {
    	int firstObjectNr = -1;
    	
    	for (int i = 0; i < equipments.size(); i++) {
            if(equipmentType.isInstance(equipments.get(i)))
                firstObjectNr = i;
        }
    	
    	return equipments.remove(firstObjectNr);
    }
    
    private List<Item> addEquipment(Item cardObject) {
    	List<Item> equipment = new ArrayList<>();
    	
    	for (int i = 0; i < cardObject.getAmountInDeck(); i++)
            equipment.add(cardObject);
    	
    	return equipment;
    }
}
