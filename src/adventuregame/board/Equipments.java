package adventuregame.board;

import java.util.ArrayList;
import java.util.List;

import adventuregame.cards.item.ACardObject;
import adventuregame.cards.item.Helm;
import adventuregame.cards.item.Tarcza;
import adventuregame.cards.item.Topor;
import adventuregame.cards.item.Zbroja;
import adventuregame.cards.item.weapon.Miecz;

public class Equipments {
	private List<ACardObject> equipments;
	
	public Equipments() {
		equipments = initEquipments();
	}
	
    private List<ACardObject> initEquipments() {
    	List<ACardObject> equipment = new ArrayList<>();
    	
    	equipment.addAll(addEquipment(new Miecz()));
    	equipment.addAll(addEquipment(new Helm()));
    	equipment.addAll(addEquipment(new Topor()));
    	equipment.addAll(addEquipment(new Tarcza()));
    	equipment.addAll(addEquipment(new Zbroja()));
    	
    	return equipment;
    }
    
    public List<ACardObject> getEquipments() {
    	return equipments;
    }
    
    public int amountOfEquipmentInDeck(Class<?> equipmentType) {
    	int amount = 0;
    	for (ACardObject equipment: equipments) {
			if (equipmentType.isInstance(equipment)) {
				amount++;
			}
		}
    	return amount;
    }
    
    public boolean isEquipemntInDeck(Class<?> equipmentType) {
    	return (amountOfEquipmentInDeck(equipmentType) > 0);
    }
    
    public ACardObject removeEquipmentFromDeck(Class<?> equipmentType) {
    	int firstObjectNr = -1;
    	
    	for (int i = 0; i < equipments.size(); i++) {
			if(equipmentType.isInstance(equipments.get(i)))
				firstObjectNr = i;
		}
    	
    	return equipments.remove(firstObjectNr);
    }
    
    private List<ACardObject> addEquipment(ACardObject cardObject) {
    	List<ACardObject> equipment = new ArrayList<>();
    	
    	for (int i = 0; i < cardObject.getAmountInDeck(); i++)
    		equipment.add(cardObject);
    	
    	return equipment;
    }
}
