package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ships.AncientShip;
import model.ships.Ship;
import model.ships.ShipBlueprint;

public class Sector {
	private int id;
	private int value;
    private int artifacts = 0;
	private String name;
	private String wormholes;
	private boolean centerWormhole;
	private boolean discoveryTile;
	private boolean monolith = false;
	private List<World> worlds;
	private List<AncientShip> ancientShips;
	private List<Ship> ships;
	private Player controllingPlayer;
	private Set<Sector> adjacentSectors = new HashSet<Sector>();
	private Set<Sector> connectedSectors = new HashSet<Sector>();
	private Set<Sector> semiconnectedSectors = new HashSet<Sector>();
	
	public Sector(int id, String name, int value, String wormholes, boolean discoveryTile, boolean artifact, boolean hasCenterWormhole, List<World> worlds, List<AncientShip> ancientShips) {
		this.id = id;
		this.value = value;
		this.name = name;
		this.wormholes = wormholes;
		this.discoveryTile = discoveryTile;
		this.worlds = worlds;
		this.ancientShips = ancientShips;
		if (artifact) {
		    artifacts = 1;
		}
		this.centerWormhole = hasCenterWormhole;
	}
	
	public Set<Sector> getAdjacentSectors() {
        return adjacentSectors;
    }

    public void addAdjacentSectors(Sector adjacentSector) {
        if (!connectedSectors.contains(adjacentSector) && !semiconnectedSectors.contains(adjacentSector)) {
            adjacentSectors.add(adjacentSector);
        }
    }

    public Set<Sector> getConnectedSectors() {
        return connectedSectors;
    }

    public void addConnectedSectors(Sector connectedSector) {
        adjacentSectors.remove(connectedSector);
        semiconnectedSectors.remove(connectedSector);
        connectedSectors.add(connectedSector);
    }

    public Set<Sector> getSemiconnectedSectors() {
        return semiconnectedSectors;
    }

    public void addSemiconnectedSectors(Sector semiconnectedSector) {
        if (!connectedSectors.contains(semiconnectedSector)) {
            adjacentSectors.remove(semiconnectedSector);
            semiconnectedSectors.add(semiconnectedSector);
        }
    }

    public int numberOfArtifacts() {
	    return artifacts;
	}
	
	public int getVPValue() {
	    return value;
	}
	
	protected void connectWormholeSectors() {
	    for (Sector sector : PlayMap.Instance.getPlacedSectors()) {
	        if (sector.hasCenterWormhole()) {
	            this.addConnectedSectors(sector);
	            sector.addConnectedSectors(this);
	        }
	    }
	}
	
	public void addWarpPortalDevelopment() {
	    value += 1;
	    centerWormhole = true;
	    connectWormholeSectors();
	}
	
	public void addWarpPortalDiscovery() {
	    value += 2;
	    centerWormhole = true;
        connectWormholeSectors();
	}
	
	public void addShellworld() {
	    value += 5;
	    worlds.add(new World(WorldType.PINK, 1, 0));
	}
	
	public boolean hasCenterWormhole() {
		return centerWormhole;
	}
	
	public boolean hasMonolith() {
	    return monolith;
	}
	
	public void addMonolith() {
	    monolith = true;
	}
	
	public boolean hasOrbital() {
	    for (World world : worlds) {
	        if (world.getType() == WorldType.ORBITAL) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void addOrbital() {
	    worlds.add(new World(WorldType.ORBITAL, 1, 0));
	}
	
	public void addOrbitalDiscovery() {
	    artifacts += 1;
	    addOrbital();
	}
	
	public void addShip(Ship ship) {
	    ships.add(ship);
	}
	
	public List<Ship> getShips() {
	    return ships;
	}
}
