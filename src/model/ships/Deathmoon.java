package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Player;

public class Deathmoon extends ShipBlueprint {
    private static final Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Antimatter_Accelerator);
        tmp.put(1, ShipPart.Hull);
        tmp.put(2, ShipPart.Hull);
        tmp.put(3, ShipPart.Electron_Computer);
        tmp.put(4, ShipPart.Nuclear_Source);
        tmp.put(5, ShipPart.Nuclear_Drive);
        blueprint = Collections.unmodifiableMap(tmp);
    }
    
    private Player player;
    
    public Deathmoon(Player player) {
        this.player = player;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        return 0;
    }

    @Override
    public int reputationDraws() {
        return 3;
    }

    @Override
    public int getInherentHull() {
        return 3;
    }

    @Override
    public int getVictoryPointValue() {
        return 4;
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    protected int getInherentPower() {
        return 0;
    }
}
