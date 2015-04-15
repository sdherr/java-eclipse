package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.PlayerSpecies;

public class Interceptor extends Ship {
    private final static Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Nuclear_Drive);
        tmp.put(1, ShipPart.Ion_Cannon);
        tmp.put(2, ShipPart.Nuclear_Source);
        tmp.put(3, ShipPart.None);
        blueprint = Collections.unmodifiableMap(tmp);
    }
    
    private Player player;
    
    public Interceptor(Player player) {
        this.player = player;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            Map<Integer, ShipPart> orionBlueprint = new HashMap<Integer, ShipPart>(blueprint);
            orionBlueprint.put(3, ShipPart.Gauss_Shield);
            return orionBlueprint;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            Map<Integer, ShipPart> plantaBlueprint = new HashMap<Integer, ShipPart>(blueprint);
            plantaBlueprint.remove(3);
            return plantaBlueprint;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 3;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 0;
        }
        if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
            return 3;
        }
        return 2;
    }

    @Override
    protected int getInherentPower() {
        if (player.getSpecies() == PlayerSpecies.Orion) {
            return 1;
        }
        if (player.getSpecies() == PlayerSpecies.Planta) {
            return 2;
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
        return 1;
    }

    @Override
    public int getNumModifiableSlots() {
        return 4;
    }
}
