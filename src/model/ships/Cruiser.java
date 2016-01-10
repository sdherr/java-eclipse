package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;

public class Cruiser extends ShipBlueprint {
    private static final Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Electron_Computer);
        tmp.put(1, ShipPart.Nuclear_Drive);
        tmp.put(2, ShipPart.Ion_Cannon);
        tmp.put(3, ShipPart.Nuclear_Source);
        tmp.put(4, ShipPart.Hull);
        tmp.put(5, ShipPart.None);
        blueprint = Collections.unmodifiableMap(tmp);
    }
    
    private Player player;
    
    public Cruiser(Player player) {
        this.player = player;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            Map<Integer, ShipPart> orionCruiser = new HashMap<Integer, ShipPart>(blueprint);
            orionCruiser.put(5, ShipPart.Gauss_Shield);
            return orionCruiser;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            Map<Integer, ShipPart> plantaCruiser = new HashMap<Integer, ShipPart>(blueprint);
            plantaCruiser.remove(5);
            plantaCruiser.put(0, ShipPart.None);
            return plantaCruiser;
        }
        if (player.getSpecies() == PlayerSpecies.Shapers) {
            Map<Integer, ShipPart> shapersCruiser = new HashMap<Integer, ShipPart>(blueprint);
            shapersCruiser.remove(5);
            shapersCruiser.put(3, ShipPart.Hull);
            shapersCruiser.put(4, ShipPart.None);
            return shapersCruiser;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 0;
        }
        if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Shapers) {
            return 0;
        }
        return 1;
    }

    @Override
    protected int getInherentPower() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Shapers) {
            return 5;
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
    protected int getInherentShields() {
        if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
            return 1;
        }
        return 0;
    }

    @Override
    public int reputationDraws() {
        return 2;
    }

    @Override
    public int getCost() {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 4;
        }
        if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
            return 6;
        }
        if (player.getSpecies() == PlayerSpecies.Unity) {
            return 4;
        }
        return 5;
    }
}
