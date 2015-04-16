package model;

import java.util.List;

import model.ships.AncientShip;
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
	private List<ShipBlueprint> ships;
	private Player controllingPlayer;
	
	public Sector(int id, String name, int value, String wormholes, boolean discoveryTile, boolean artifact, List<World> worlds, List<AncientShip> ancientShips) {
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
	}
	
	public int numberOfArtifacts() {
	    return artifacts;
	}
	
	public int getVPValue() {
	    return value;
	}
	
	public void addWarpPortalDevelopment() {
	    value += 1;
	    centerWormhole = true;
	}
	
	public void addWarpPortalDiscovery() {
	    value += 2;
	    centerWormhole = true;
	}
	
	public void addShellworld() {
	    value += 5;
	    worlds.add(new World(WorldType.PINK, 1, 0));
	}
	
	public boolean hasCenterWormhole() {
		return centerWormhole;
	}
	
	public void setCenterWormhole() {
	    centerWormhole = true;
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
}
