package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ships.AncientInterceptor;
import model.ships.AncientShip;
import model.ships.Ship;
import model.ships.ShipBlueprint;

public class Sector {
    private final int id;
    private final String name;
    
    // location in axial coordinants
    private int q;
    private int r;
    
	private int value;
    private int artifacts = 0;
	private String wormholes;
	private boolean centerWormhole;
	private boolean deepWarp = false;
	private Map<Integer, Sector> nebula;
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
        this.name = name;
		this.value = value;
		this.wormholes = wormholes;
		this.discoveryTile = discoveryTile;
		this.worlds = worlds;
		this.ancientShips = ancientShips;
		if (artifact) {
		    artifacts = 1;
		}
		this.centerWormhole = hasCenterWormhole;
	}
	
	/**
	 * Place a sector on the board
	 * @param q axial coordinate
	 * @param r axial coordinate
	 * @param rotation a number representing how the sector has been rotated from the "beginning" orrientation.
	 *   Positive = clockwise
	 */
	public void place(int q, int r, int rotation) {
	    this.q = q;
	    this.r = r;
	    // translate rotation into an equivalent 0-5 representation
	    while (rotation < 0) {
	        rotation += 6;
	    }
	    while (rotation > 5) {
	        rotation -= 6;
	    }
	    // move wormholes
	    while (rotation > 0) {
	        // take the wormhole off the end and add it to the beginning
	        wormholes = wormholes.substring(6) + wormholes.substring(0, 6);
	        if (isNebula()) {
	            Map<Integer, Sector> newNebula = new HashMap<Integer, Sector>();
	            newNebula.put(0, nebula.get(5));
                newNebula.put(1, nebula.get(0));
                newNebula.put(2, nebula.get(1));
                newNebula.put(3, nebula.get(2));
                newNebula.put(4, nebula.get(3));
                newNebula.put(5, nebula.get(4));
                nebula = newNebula;
	        }
	        rotation--;
	    }
	    
	    calculateConnections();
	}
	
	protected void calculateConnections() {
	    Sector left = PlayMap.Instance.getSector(q-1, r);
	    Sector leftDown = PlayMap.Instance.getSector(q-1, r+1);
	    Sector leftUp = PlayMap.Instance.getSector(q, r-1);
        Sector rightDown = PlayMap.Instance.getSector(q, r+1);
        Sector rightUp = PlayMap.Instance.getSector(q+1, r-1);
        Sector right = PlayMap.Instance.getSector(q+1, r);
        Map<Sector, Integer> sector_to_wormhole_index = new HashMap<Sector, Integer>();
        sector_to_wormhole_index.put(rightUp, 0);
        sector_to_wormhole_index.put(right, 1);
        sector_to_wormhole_index.put(rightDown, 2);
        sector_to_wormhole_index.put(leftDown, 3);
        sector_to_wormhole_index.put(left, 4);
        sector_to_wormhole_index.put(leftUp, 5);
        for (Sector neighbor : sector_to_wormhole_index.keySet()) {
            if (neighbor != null) {
                int my_index = sector_to_wormhole_index.get(neighbor);
                int his_index = my_index + 3;
                if (his_index > 5) {
                    his_index -= 6;
                }
                // if either one of us is a nebula we want to connect to the sub-sector
                Sector me = this;
                if (isNebula()) {
                    me = nebula.get(my_index);
                }
                if (neighbor.isNebula()) {
                    neighbor = neighbor.nebula.get(his_index);
                }
                // now finally the real part
                if (wormholes.charAt(my_index) == '1' && neighbor.wormholes.charAt(his_index) == '1') {
                    addConnectedSectors(neighbor);
                    neighbor.addConnectedSectors(this);
                } else if (wormholes.charAt(my_index) == '1' && neighbor.wormholes.charAt(his_index) == '1') {
                    addSemiconnectedSectors(neighbor);
                    neighbor.addSemiconnectedSectors(this);
                } else {
                    addAdjacentSectors(neighbor);
                    neighbor.addAdjacentSectors(this);
                }
            }
        }
        if (hasCenterWormhole()) {
            connectWormholeSectors();
        }
        if (isDeepWarp()) {
            Sector nexus = PlayMap.Instance.getNexus();
            addConnectedSectors(nexus);
            nexus.addConnectedSectors(this);
        }
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
	
	public List<AncientShip> getAncientShips() {
	    return ancientShips;
	}
	
	public boolean isDeepWarp() {
	    return deepWarp;
	}
	
	public void setDeepWarp() {
	    deepWarp = true;
	}
	
	public boolean isNebula() {
	    return nebula == null;
	}
	
	public void setNebula() {
	    List<World> worlds = new ArrayList<World>();
        List<AncientShip> ships = new ArrayList<AncientShip>();
	    Sector a = new Sector(-1, "", 0, "111111", true, false, false, worlds, ships);
	    worlds = new ArrayList<World>();
	    ships = new ArrayList<AncientShip>();
        Sector b = new Sector(-2, "", 0, "111111", true, false, false, worlds, ships);
        worlds = new ArrayList<World>();
        ships = new ArrayList<AncientShip>();
        ships.add(new AncientInterceptor());
        Sector c = new Sector(-3, "", 0, "111111", false, false, false, worlds, ships);
        nebula = new HashMap<Integer, Sector>();
        nebula.put(0, a);
        nebula.put(1, c);
        nebula.put(2, c);
        nebula.put(3, b);
        nebula.put(4, b);
        nebula.put(5, a);
        a.addAdjacentSectors(b);
        b.addAdjacentSectors(a);
        a.addAdjacentSectors(c);
        c.addAdjacentSectors(a);
        b.addAdjacentSectors(c);
        c.addAdjacentSectors(b);
	}
}
