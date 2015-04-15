package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;
import model.Technology;

public class Starbase extends Ship {
    private static final Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Electron_Computer);
        tmp.put(1, ShipPart.Ion_Cannon);
        tmp.put(2, ShipPart.Hull);
        tmp.put(3, ShipPart.None);
        tmp.put(4, ShipPart.Hull);
        blueprint = Collections.unmodifiableMap(tmp);
    }
    
    private Player player;
    
    public Starbase(Player player) {
        this.player = player;
    }

    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            Map<Integer, ShipPart> orionStarbase = new HashMap<Integer, ShipPart>(blueprint);
            orionStarbase.put(3, ShipPart.Gauss_Shield);
            return orionStarbase;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            Map<Integer, ShipPart> plantaStarbase = new HashMap<Integer, ShipPart>(blueprint);
            plantaStarbase.remove(3);
            return plantaStarbase;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 5;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 2;
        }
        return 4;
    }

    @Override
    protected int getInherentPower() {
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 5;
        }
        return 3;
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
        return 1;
    }
    
    @Override
    protected boolean shipCanHaveDrive() {
        return false;
    }

    /*
     * I really wanted to have in Purchasable interface that specified static
     * canBePurchased(Player) and getCost(Player), but java < 8 doesn't support
     * static methods in interfaces. Instead Purchasable classes will just
     * magically have these methods, and something else will "know" that they
     * are the only purchasable things.
     */
    public static boolean canBePurchased(Player player) {
        if (player.getSpecies() == PlayerSpecies.Exiles) {
            return false;
        }
        return player.hasResearched(Technology.Starbase);
    }

    public static int getCost(Player player) {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 2;
        }
        if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
            return 4;
        }
        return 3;
    }
}
