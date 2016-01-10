package model.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.WorldType;

/*
 * Kind of funky, what we want to do is create a random Anomaly.
 * Subsequent instantiations should not return the same Anomaly.
 */
public class Anomaly extends AncientShip {
    private static enum AnomalyType {A, B, C, D, E, F}
    private static List<AnomalyType> types;
    static {
        types = new ArrayList<AnomalyType>();
        types.add(AnomalyType.A);
        types.add(AnomalyType.B);
        types.add(AnomalyType.C);
        types.add(AnomalyType.D);
        types.add(AnomalyType.E);
        types.add(AnomalyType.F);
        Collections.shuffle(types);
    }
    
    private AnomalyType type;
    private boolean isMobile;
    private WorldType color;

    public Anomaly(boolean isMobile) {
        type = types.get(0);
        types.remove(0);
        this.isMobile = isMobile;
    }
    
    public boolean isMobile() {
        return isMobile;
    }
    
    public WorldType getWorldType() {
        return color;
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        Map<Integer, ShipPart> blueprint = new HashMap<Integer, ShipPart>();
        blueprint.put(0, ShipPart.Improved_Hull);
        blueprint.put(1, ShipPart.Improved_Hull);
        blueprint.put(2, ShipPart.Improved_Hull);
        blueprint.put(3, ShipPart.Rift_Turret);
        blueprint.put(4, ShipPart.Rift_Cannon);
        if (!isMobile()) { 
            return blueprint;
        }
        
        blueprint.put(5, ShipPart.Nuclear_Drive);
        blueprint.put(6, ShipPart.Anomoly_Cannon);
        blueprint.put(7, ShipPart.Improved_Hull);
        switch (type) {
        case A:
        case B:
            this.color = WorldType.PINK;
            blueprint.put(8, ShipPart.Rift_Cannon);
            break;
        case C:
        case D:
            this.color = WorldType.ORANGE;
            blueprint.put(8, ShipPart.Improved_Hull);
            break;
        case E:
        case F:
            this.color = WorldType.BROWN;
            blueprint.put(8, ShipPart.Improved_Hull);
            blueprint.put(4, ShipPart.Improved_Hull); // replace rift cannon with hull
            break;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (!isMobile) {
            return 0;
        }
        switch (type) {
        case A:
        case B:
            return -1; //negate out the nuclear drive
        case C:
        case D:
            return 0;
        case E:
        case F:
        default:
            return 1;
        }
    }

    @Override
    public int reputationDraws() {
        return 3;
    }

    @Override
    public int getVictoryPointValue() {
        return 1;
    }
    
    @Override
    protected boolean shipCanHaveDrive() {
        return isMobile;
    }
}
