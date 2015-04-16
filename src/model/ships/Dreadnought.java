package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;

public class Dreadnought extends ShipBlueprint {
    private static final Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Ion_Cannon);
        tmp.put(1, ShipPart.Electron_Computer);
        tmp.put(2, ShipPart.Nuclear_Drive);
        tmp.put(3, ShipPart.Hull);
        tmp.put(4, ShipPart.Nuclear_Source);
        tmp.put(5, ShipPart.Ion_Cannon);
        tmp.put(6, ShipPart.Hull);
        tmp.put(7, ShipPart.None);
        blueprint = Collections.unmodifiableMap(tmp);
    }
    
    private Player player;
    
    public Dreadnought(Player player) {
        this.player = player;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            Map<Integer, ShipPart> orionDreadnought = new HashMap<Integer, ShipPart>(blueprint);
            orionDreadnought.put(7, ShipPart.Gauss_Shield);
            return orionDreadnought;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            Map<Integer, ShipPart> plantaDreadnought = new HashMap<Integer, ShipPart>(blueprint);
            plantaDreadnought.remove(4);
            plantaDreadnought.put(1, ShipPart.None);
            plantaDreadnought.put(3, ShipPart.Nuclear_Source);
            plantaDreadnought.put(7, ShipPart.Hull);
            return plantaDreadnought;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 1;
        }
        return 0;
    }

    @Override
    protected int getInherentPower() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 3;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Eridani) {
            return 1;
        }
        return 0;
    }
    
    @Override
    protected int getInherentComputers() {
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 1;
        }
        return 0;
    }

    @Override
    public int reputationDraws() {
        return 3;
    }

    @Override
    public int getNumModifiableSlots() {
        return 7;
    }

    @Override
    public int getCost() {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 7;
        }
        return 8;
    }
}
