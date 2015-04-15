package model.ships;

import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;
import model.Technology;

/*
 * Orbitals aren't really ships except for exiles. Oh well.
 */
public class Orbital extends Ship {
    Player player;
    
    public Orbital(Player player) {
        this.player = player;
    }

    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        Map<Integer, ShipPart> blueprint = new HashMap<Integer, ShipPart>();
        if (player.getSpecies() != PlayerSpecies.Exiles){
            return blueprint;
        }
        blueprint.put(0, ShipPart.Hull);
        blueprint.put(1, ShipPart.Ion_Turret);
        blueprint.put(2, ShipPart.Hull);
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        return 0;
    }

    @Override
    protected int getInherentPower() {
        if (player.getSpecies() == PlayerSpecies.Exiles){
            return 4;
        }
        return 0;
    }

    @Override
    public int reputationDraws() {
        if (player.getSpecies() == PlayerSpecies.Exiles){
            return 1;
        }
        return 0;
    }
    
    @Override
    protected boolean shipCanHaveDrive() {
        return false;
    }

    @Override
    protected int getInherentHull() {
        if (player.getSpecies() == PlayerSpecies.Exiles){
            return 1;
        }
        return 0;
    }

    /*
     * I really wanted to have in Purchasable interface that specified static
     * canBePurchased(Player) and getCost(Player), but java < 8 doesn't support
     * static methods in interfaces. Instead Purchasable classes will just
     * magically have these methods, and something else will "know" that they
     * are the only purchasable things.
     */
    public static boolean canBePurchased(Player player) {
        return player.hasResearched(Technology.Orbital);
    }

    public static int getCost(Player player) {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 4;
        }
        if (player.getSpecies() == PlayerSpecies.Exiles) {
            return 6;
        }
        return 5;
    }
}
