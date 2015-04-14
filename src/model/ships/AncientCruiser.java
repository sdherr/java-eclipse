package model.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Kind of funky, what we want to do is create a random AncientCruiser.
 * Subsequent instantiations should not return the same Cruiser.
 */
public class AncientCruiser extends AncientShip {
    private static enum CruiserType {A, B, C, D, E, F, G, H}
    private static List<CruiserType> types;
    static {
        types = new ArrayList<CruiserType>();
        types.add(CruiserType.A);
        types.add(CruiserType.B);
        types.add(CruiserType.C);
        types.add(CruiserType.D);
        types.add(CruiserType.E);
        types.add(CruiserType.F);
        types.add(CruiserType.G);
        types.add(CruiserType.H);
        Collections.shuffle(types);
    }
    
    private CruiserType type;

    public AncientCruiser() {
        type = types.get(0);
        types.remove(0);
    }
    
    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        Map<Integer, ShipPart> blueprint = new HashMap<Integer, ShipPart>();
        switch (type) {
        case A:
            blueprint.put(0, ShipPart.Antimatter_Cannon);
            blueprint.put(1, ShipPart.Axion_Computer);
            blueprint.put(2, ShipPart.Improved_Hull);
            blueprint.put(3, ShipPart.Improved_Hull);
            break;
        case B:
            blueprint.put(0, ShipPart.Ion_Turret);
            blueprint.put(1, ShipPart.Ion_Turret);
            blueprint.put(2, ShipPart.Improved_Hull);
            blueprint.put(3, ShipPart.Electron_Computer);
            blueprint.put(4, ShipPart.Gauss_Shield);
            break;
        case C:
            blueprint.put(0, ShipPart.Ion_Turret);
            blueprint.put(1, ShipPart.Ion_Cannon);
            blueprint.put(2, ShipPart.Positron_Computer);
            blueprint.put(3, ShipPart.Improved_Hull);
            break;
        case D:
            blueprint.put(0, ShipPart.Plasma_Missile);
            blueprint.put(1, ShipPart.Ion_Turret);
            blueprint.put(2, ShipPart.Hull);
            blueprint.put(3, ShipPart.Positron_Computer);
            break;
        case E:
            blueprint.put(0, ShipPart.Antimatter_Missile);
            blueprint.put(1, ShipPart.Plasma_Cannon);
            blueprint.put(2, ShipPart.Positron_Computer);
            blueprint.put(3, ShipPart.Hull);
            break;
        case F:
            blueprint.put(0, ShipPart.Ion_Turret);
            blueprint.put(1, ShipPart.Positron_Computer);
            blueprint.put(2, ShipPart.Improved_Hull);
            blueprint.put(3, ShipPart.Improved_Hull);
            break;
        case G:
            blueprint.put(0, ShipPart.Improved_Hull);
            blueprint.put(1, ShipPart.Plasma_Cannon);
            blueprint.put(2, ShipPart.Plasma_Cannon);
            blueprint.put(3, ShipPart.Electron_Computer);
            break;
        case H:
            blueprint.put(0, ShipPart.Improved_Hull);
            blueprint.put(1, ShipPart.Ion_Turret);
            blueprint.put(2, ShipPart.Ion_Cannon);
            blueprint.put(3, ShipPart.Electron_Computer);
            blueprint.put(4, ShipPart.Flux_Shield);
            break;
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (type == CruiserType.C || type == CruiserType.G) {
            return 3; // positron computer provides one for C
        }
        else if (type == CruiserType.E || type == CruiserType.F){
            return 1; // positron computer provides one
        }
        return 0;
    }
    
    public boolean hasPointDefence() {
        return type == CruiserType.F;
    }
    
    public boolean hasDistortionShield() {
        return type == CruiserType.E;
    }

    @Override
    public int reputationDraws() {
        return 2;
    }

    @Override
    public int getVictoryPointValue() {
        return 1;
    }

    @Override
    protected boolean shipCanHaveDrive() {
        return false;
    }
}
