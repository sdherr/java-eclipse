package model.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Similar to AncientCruiser, except there are only three options and we may want
 * to let the user choose one, and there will only ever be one instantiation of this class.
 * For simplicity's sake we'll also consider the gcds to be a type of ancient dreadnought.
 */
public class AncientDreadnought extends AncientShip {
    public static enum Type {A, B, GCDS}
    
    private Type type;
    
    // randomly choose one of the "real" ancient dreadnoughts
    public AncientDreadnought() {
        List<Type> types = new ArrayList<Type>();
        types.add(Type.A);
        types.add(Type.B);
        Collections.shuffle(types);
        type = types.get(0);
    }
    
    public AncientDreadnought(Type type) {
        this.type = type;
    }

    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        Map<Integer, ShipPart> blueprint = new HashMap<Integer, ShipPart>();
        if (type == Type.A){ 
            blueprint.put(0, ShipPart.Improved_Hull);
            blueprint.put(1, ShipPart.Improved_Hull);
            blueprint.put(2, ShipPart.Hull);
            blueprint.put(3, ShipPart.Plasma_Cannon);
            blueprint.put(4, ShipPart.Plasma_Cannon);
            blueprint.put(5, ShipPart.Ancient_Shield);
            blueprint.put(6, ShipPart.Positron_Computer);
        }
        else if (type == Type.B){
            blueprint.put(0, ShipPart.Improved_Hull);
            blueprint.put(1, ShipPart.Hull);
            blueprint.put(2, ShipPart.Flux_Missile);
            blueprint.put(3, ShipPart.Flux_Missile);
            blueprint.put(4, ShipPart.Positron_Computer);
            blueprint.put(5, ShipPart.Antimatter_Cannon);
        }
        else {
            blueprint.put(0, ShipPart.Improved_Hull);
            blueprint.put(1, ShipPart.Improved_Hull);
            blueprint.put(2, ShipPart.Improved_Hull);
            blueprint.put(3, ShipPart.Hull);
            blueprint.put(4, ShipPart.Ion_Turret);
            blueprint.put(5, ShipPart.Ion_Turret);
            blueprint.put(6, ShipPart.Electron_Computer);
        }
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        if (type == Type.A){
            return 2; // positron computer adds one
        }
        else if (type == Type.B){ 
            return -1; // two flux missiles and a positron computer would be 5, need 4
        }
        return 0;
    }

    @Override
    public int reputationDraws() {
        return 3;
    }

    @Override
    public int getVictoryPointValue() {
        if (type == Type.GCDS) {
            return 0;
        }
        return 1;
    }

    @Override
    protected boolean shipCanHaveDrive() {
        return false;
    }
}
