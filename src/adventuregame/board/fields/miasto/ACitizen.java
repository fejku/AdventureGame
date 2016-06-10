package adventuregame.board.fields.miasto;

import adventuregame.explorer.Explorer;

public abstract class ACitizen implements ICitizen{
	private final String name;
	
	public ACitizen(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean isValid(Explorer explorer) {
		return true;
	}
}
