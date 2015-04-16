package model.ships;

import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;

/*
 * Monoliths are not ships in any respect, but they can chill here with everything
 * else that is buildable.
 */
public class Monolith extends ShipBlueprint {
    Player player;
    public Monolith (Player player) {
        this.player = player;
    }

    @Override
    public int getCost() {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 8;
        }
        return 10;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        return new HashMap<Integer, ShipPart>();
    }

    @Override
    protected int getInherentInitiative() {
        return 0;
    }

    @Override
    protected int getInherentPower() {
        return 0;
    }

    @Override
    public int reputationDraws() {
        return 0;
    }
}
