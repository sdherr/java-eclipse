package model;

import java.util.ArrayList;

import model.ships.AncientShip;

public class NebulaSector extends Sector {
    // TODO: this
    public NebulaSector(int id, String name) {
        super(id, name, 0, "111111", false, false, false, new ArrayList<World>(), new ArrayList<AncientShip>());
    }
}
