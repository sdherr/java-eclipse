package model.ships;

import model.Player;
import model.Sector;

public class Ship {
    private Player owner;
    private Sector location;
    private ShipType type;

    public Ship(Player owner, Sector location, ShipType type) {
        this.owner = owner;
        this.location = location;
        this.type = type;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public Sector getLocation() {
        return location;
    }
    
    public void setLocation(Sector location) {
        this.location = location;
    }
    
    public ShipType getType() {
        return type;
    }
}
