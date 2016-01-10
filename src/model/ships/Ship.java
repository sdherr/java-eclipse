package model.ships;

import java.util.HashSet;
import java.util.Set;

import model.Player;
import model.Sector;
import model.Technology;

public class Ship {
    private Player owner;
    private Sector location;
    private ShipType type;

    public Ship(Player owner, Sector location, ShipType type) {
        this.owner = owner;
        this.location = location;
        this.type = type;
    }
    
    public Set<Sector> getNavagatableSectors() {
        int drive = owner.getShipBlueprint(type).getDrive();
        boolean hasJumpDrive = owner.getShipBlueprint(type).hasJumpDrive();
        boolean hasWormholeGenerator = owner.hasResearched(Technology.Wormhole_Generator);
        boolean hasCloakingDevice = owner.hasResearched(Technology.Cloaking_Device);
        Set<Sector> sectors =  getNavagatableSectors(location, drive, hasJumpDrive, hasWormholeGenerator, hasCloakingDevice);
        sectors.remove(location);
        return sectors;
    }
    
    private boolean pinnedInSector(Sector sector, boolean hasCloakingDevice) {
        int enemyShips = 0;
        int alliedShips = 0;
        int ownShips = 0;
        for (Ship ship : sector.getShips()) {
            Player player = ship.getOwner();
            if (player == owner) {
                ownShips += 1;
            }
            else if (owner.getAllies().contains(player)) {
                alliedShips += 1;
            }
            else {
                enemyShips += 1;
            }
        }
        if ((enemyShips - alliedShips) <= ownShips) {
            return false;
        }
        if (hasCloakingDevice && (enemyShips - alliedShips) / 2 <= ownShips) {
            return false;
        }
        return true;
    }
    
    private Set<Sector> getNavagatableSectors(Sector current, int drive, boolean hasJumpDrive, boolean hasWormholeGenerator, boolean hasCloakingDevice) {
        Set<Sector> navagatableSectors = new HashSet<Sector>();
        navagatableSectors.add(current);
        if (drive == 0 || pinnedInSector(current, hasCloakingDevice)) {
            return navagatableSectors;
        }
        
        for (Sector sector : current.getConnectedSectors()) {
            navagatableSectors.addAll(getNavagatableSectors(sector, drive - 1, hasJumpDrive, hasWormholeGenerator, hasCloakingDevice));
        }
        
        if (hasWormholeGenerator) {
            for (Sector sector : current.getSemiconnectedSectors()) {
                navagatableSectors.addAll(getNavagatableSectors(sector, drive - 1, hasJumpDrive, hasWormholeGenerator, hasCloakingDevice));
            }
        }
        
        if (hasJumpDrive) {
            for (Sector sector : current.getAdjacentSectors()) {
                navagatableSectors.addAll(getNavagatableSectors(sector, drive - 1, false, hasWormholeGenerator, hasCloakingDevice));
            }
            if (!hasWormholeGenerator) {
                for (Sector sector : current.getSemiconnectedSectors()) {
                    navagatableSectors.addAll(getNavagatableSectors(sector, drive - 1, false, hasWormholeGenerator, hasCloakingDevice));
                }
            }
        }

        return navagatableSectors;
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
