package model;

import java.util.List;

import model.ships.AncientShip;
import model.ships.Ship;

public class Sector {
	private int id;
	private int value;
	private String name;
	private String wormholes;
	private boolean centerWormhole;
	private boolean discoveryTile;
	private boolean star;
	private boolean monolith = false;
	private List<World> worlds;
	private List<AncientShip> ancientShips;
	private List<Ship> ships;
	private Player controllingPlayer;
	
	public Sector(int id, String name, int value, String wormholes, boolean discoveryTile, boolean star, List<World> worlds, List<AncientShip> ancientShips) {
		this.id = id;
		this.value = value;
		this.name = name;
		this.wormholes = wormholes;
		this.discoveryTile = discoveryTile;
		this.star = star;
		this.worlds = worlds;
		this.ancientShips = ancientShips;
	}
	
	public void setCenterWormhole() {
		centerWormhole = true;
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
}
