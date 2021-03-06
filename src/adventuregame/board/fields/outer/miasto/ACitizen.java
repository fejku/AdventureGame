package adventuregame.board.fields.outer.miasto;

import adventuregame.explorer.Explorer;

public abstract class ACitizen implements ICitizen{
    private final String name;

    public ACitizen(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isValid(Explorer explorer) {
        return true;
    }
}
