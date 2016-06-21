package adventuregame.cards.events;

import java.util.List;

import adventuregame.board.Board;
import adventuregame.board.Board.GameState;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.ExplorerCharacter;
import adventuregame.explorer.Explorers;

/**
 *
 * @author Fake
 */
public class DzienDuchow extends Event {

    public DzienDuchow() {
        super("Dzien Duchów", false);
    }

    @Override
    public void mainAction(Board board, Explorers explorers) {
        board.getDialog().message("Nadszedł Dzień Duchów. Każdy Zły Poszukiwacz może wzywać duchy - rzucając kostką, żeby się przekonać, z jakim rezultatem:\n1. traci 1 turę\n2-4. odzyskuje 1 punkt Wytrzymałości\n5-6. zyskuje 1 Czar.\nPo wezwaniu duchów należy odłożyć tę Kartę.");
        List<Explorer> evilExplorers = explorers.getExplorersByCharacter(ExplorerCharacter.ZLY, false);
        
        for (Explorer evilExplorer : evilExplorers) {
            if (board.getDialog().chooseYesNo(evilExplorer.getName() + " wzywasz duchy?"))
                summonGhosts(board, evilExplorer);
        }
    }

    private void summonGhosts(Board board, Explorer explorer) {
        switch (board.getDice().throwDice()) {
            case 1:
                explorer.loseTurn();
                board.setGameState(GameState.TURN_END);
                break;
            case 2:
            case 3:
            case 4:
                explorer.regainLife();
                break;
            case 5:
            case 6:
                explorer.gainSpell(board);
                break;
            default:
                board.getDialog().message("Nieobsłużony wynik rzutu kostką w klasie DzienDuchow w metodzie summonGhosts.");
        }
    }
}
