package model.ships;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AncientInterceptor extends AncientShip {
    private static final Map<Integer, ShipPart> blueprint;
    static {
        Map<Integer, ShipPart> tmp = new HashMap<Integer, ShipPart>();
        tmp.put(0, ShipPart.Ion_Cannon);
        tmp.put(1, ShipPart.Ion_Cannon);
        tmp.put(2, ShipPart.Electron_Computer);
        tmp.put(3, ShipPart.Hull);
        tmp.put(4, ShipPart.Nuclear_Drive);
        blueprint = Collections.unmodifiableMap(tmp);
    }

    @Override
    protected Map<Integer, ShipPart> getInitialBlueprint() {
        return blueprint;
    }

    @Override
    protected int getInherentInitiative() {
        return 1; // nuke drive provides 1
    }

    @Override
    public int reputationDraws() {
        return 1;
    }
}
