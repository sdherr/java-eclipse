package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ships.AncientCruiser;
import model.ships.AncientInterceptor;
import model.ships.AncientShip;
import model.ships.Anomaly;
import model.ships.Ship;
import model.ships.ShipBlueprint;

public enum Sector {
    Galactic_Center(001, 4, "111111", true, true, 1,1, 1,1, 0,0, 2,0, 0), // TODO add GCDS
    Gastor(101, 2, "011111", true, false, 1,1, 0,0, 1,0, 0,0, 1),
    Pollux(102, 3, "101101", false, true, 0,0, 1,1, 0,0, 0,0, 0),
    Beta_Lenois(103, 2, "111011", false, false, 0,0, 0,0, 0,1, 1,0, 0),
    Arcturus(104, 2, "110110", true, false, 0,0, 1,1, 1,1, 0,0, 2),
    Zeta_Herculis(105, 3, "110111", true, true, 0,1, 1,0, 1,0, 0,0, 1),
    Capella(106, 2, "111100", false, false, 1,0, 1,0, 0,0, 0,0, 0),
    Aldebaran(107, 2, "111101", false, false, 0,1, 0,1, 1,0, 0,0, 0),
    Mu_Cassiopiae(108, 2, "110110", true, false, 0,0, 1,0, 0,1, 1,0, 1),
    Alpha_Centauri(201, 1, "010101", false, false, 1,0, 0,0, 1,0, 0,0, 0),
    Fomalhaut(202, 1, "010101", false, false, 0,0, 1,1, 0,0, 0,0, 0),
    Chi_Draconis(203, 1, "110101", true, false, 1,0, 1,0, 1,0, 0,0, 2),
    Vega(204, 2, "110101", true, true, 0,1, 0,0, 0,1, 1,0, 1),
    Mu_Herculis(205, 1, "001110", false, false, 0,0, 0,1, 1,1, 0,0, 0),
    Epsilon_Indi(206, 1, "011101", true, false, 1,0, 0,0, 0,0, 0,0, 0),
    Zeta_Reticuli(207, 1, "110100", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    Iota_Persei(208, 1, "101101", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    Delta_Eridani(209, 1, "110101", false, false, 0,0, 1,0, 0,1, 0,0, 0),
    Psi_Capricorni(210, 1, "100101", false, false, 1,0, 0,0, 1,0, 0,0, 0),
    Beta_Aquilae(211, 2, "111100", true, true, 0,1, 0,0, 1,0, 1,0, 1),
    Procyon(221, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Epsilon_Eridani(222, 3, "110110", false, true, 0,0, 1,1, 1,1, 0,0, 0),
    Altair(223, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Beta_Hydri(224, 3, "110110", false, true, 0,1, 1,1, 1,0, 0,0, 0),
    Eta_Cassiopeiae(225, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    S1_Cygni(226, 3, "110110", false, true, 1,0, 1,0, 1,0, 0,0, 0),
    Sirius(227, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Sigma_Draconis(228, 3, "110110", false, true, 0,1, 1,0, 1,0, 0,0, 0),
    Tau_Ceti(229, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Lambda_Aurigae(230, 3, "110110", false, true, 0,1, 1,0, 1,1, 0,0, 0),
    Delta_Pavonis(231, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Rigel(232, 3, "110110", false, true, 1,1, 1,0, 0,1, 0,0, 0),
    Zeta_Draconis(301, 2, "101100", true, true, 0,1, 1,0, 1,0, 0,0, 2),
    Gamma_Serpentis(302, 2, "100110", true, true, 1,0, 0,0, 0,1, 0,0, 1),
    Eta_Cephei(303, 2, "000101", true, true, 0,0, 0,0, 0,0, 1,0, 1),
    Theta_Pegasi(304, 1, "100100", false, false, 1,0, 0,0, 0,1, 0,0, 0),
    Lambda_Serpentis(305, 1, "110100", true, false, 1,0, 1,0, 0,0, 0,0, 1),
    Beta_Centauri(306, 1, "010100", false, false, 1,0, 0,0, 1,0, 0,0, 0),
    Sigma_Sagittarii(307, 1, "101100", false, false, 0,0, 0,1, 1,0, 0,0, 0),
    Kappa_Scorpii(308, 1, "001101", false, false, 0,1, 1,0, 0,0, 0,0, 0),
    Phi_Piscium(309, 1, "100101", false, false, 0,0, 0,1, 1,0, 0,0, 0),
    Nu_Phoenicis(310, 1, "100100", false, false, 1,0, 1,0, 0,0, 0,0, 0),
    Canopus(311, 1, "101100", true, false, 1,0, 0,0, 0,0, 0,0, 0),
    Antares(312, 1, "110100", true, false, 1,0, 0,0, 0,0, 0,0, 0),
    Alpha_Ursae_Minoris(313, 1, "100100", true, false, 0,0, 0,0, 0,0, 1,0, 0),
    Spica(314, 1, "001110", true, false, 0,0, 0,0, 0,0, 1,0, 0),
    Epsilon_Aurigae(315, 1, "100101", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    Iota_Carinae(316, 1, "110100", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    Beta_Crucis(317, 1, "000110", false, false, 0,0, 0,0, 1,1, 0,0, 0),
    Gamma_Velorum(318, 1, "001100", false, false, 0,1, 0,0, 0,0, 1,0, 0),
    // Rise of the Ancients
    Lambda_Fornacis(212, 2, "111111", true, false, 1,0, 0,1, 1,0, 0,0, 3),
    Iota_Bootis(213, 1, "110101", false, false, 1,0, 1,0, 0,0, 0,0, 0),
    Ursae_Majois_47(233, 3, "110110", false, true, 1,0, 1,1, 1,1, 0,0, 0),
    Eta_Geminorum(234, 3, "110110", false, true, 1,1, 0,0, 0,1, 0,0, 0),
    Mu_Arae(235, 3, "110110", false, true,  1,0, 1,1, 1,1, 0,0, 0),
    Rho_Indi(236, 0, "110110", false, true, 1,0, 0,1, 1,1, 0,0, 0),
    Cancri_55(237, 3, "110110", false, true,  1,0, 1,1, 1,1, 0,0, 0),
    Beta_Lyrae(238, 3, "110110", false, true, 1,1, 1,1, 1,1, 0,0, 0),
    Omega_Fornacis(271, 3, "110110", true, true, 0,1, 1,0, 1,0, 0,0, 0),
    Sigma_Hydrae(272, 3, "110110", true, true, 1,0, 0,1, 1,0, 0,0, 0),
    Theta_Ophiuchi(273, 3, "110110", true, true, 1,1, 0,0, 1,0, 0,0, 0),
    Alpha_Lyncis(274, 3, "110110", true, true, 0,0, 1,1, 1,0, 0,0, 0),
    Delta_Corvi(281, 2, "101101", true, false, 0,0, 0,0, 1,0, 0,0, 0),
    Upsilon_Hydrae(319, 2, "111111", true, false, 1,1, 1,0, 0,1, 0,0, 3),
    Nu_Ophiuchi(320, 1, "001110", true, false, 0,0, 1,0, 1,0, 0,0, 1),
    Beta_Delphini(321, 1, "100101", false, false, 0,0, 0,0, 1,1, 0,0, 0),
    Lambda_Tauri(322, 1, "110100", false, false, 0,0, 1,1, 0,0, 0,0, 0),
    Zeta_Andromedae(323, 1, "110101", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    Epsilon_Carinae(324, 2, "101101", false, true, 0,0, 0,0, 0,0, 1,0, 0),
    Delta_Sextantis(381, 2, "100110", true, false, 0,0, 1,0, 0,0, 0,0, 0),
    Zeta_Chamaeleontis(382, 2, "101100", true, false, 1,0, 0,0, 0,0, 0,0, 0),
    // Nebula
    NGC_5189(295, 0, "111111", false, false, 0,0, 0,0, 0,0, 0,0, 0),
    NGC_1952(395, 0, "111111", false, false, 0,0, 0,0, 0,0, 0,0, 0),
    _Nebula_Sub_A(-1, 0, "111111", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    _Nebula_Sub_B(-2, 0, "111111", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    _Nebula_Sub_C(-3, 0, "111111", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    _Nebula_Sub_D(-4, 0, "111111", true, false, 0,0, 0,0, 0,0, 0,0, 0),
    _Nebula_Sub_E(-5, 0, "111111", false, false, 0,0, 0,0, 0,0, 0,0, 1),
    _Nebula_Sub_F(-6, 0, "111111", false, false, 0,0, 0,0, 0,0, 0,0, 1),
    // Shadow of the Rift
    Alpha_Lacertae(109, 4, "011111", true, false, 0,0, 0,0, 1,0, 0,0, 2),
    Gamma_Bootis(110, 2, "101110", true, false, 0,0, 0,0, 0,1, 0,1, 0),
    Alpha_Scuti(189, 2, "110110", false, false, 1,0, 0,0, 1,0, 0,1, 0),
    Beta_Monocerotis(214, 1, "111011", true, false, 0,1, 1,0, 0,0, 0,1, 1),
    Theta_Octantis(241, 3, "110110", false, true, 1,0, 0,1, 1,1, 0,0, 0),
    Kappa_Pyxidis(242, 3, "110110", false, true, 0,0, 0,0, 0,0, 1,1, 0),
    Nu_Octantis(243, 3, "110110", false, true, 1,0, 0,1, 1,1, 0,0, 0),
    Zeta_Doradus(244, 3, "110110", false, true, 1,0, 0,1, 1,1, 0,0, 0),
    Delta_Scuti(289, 1, "010101", false, false, 1,0, 1,0, 0,0, 0,1, 0),
    Epsilon_Scuti(389, 1, "010100", false, false, 0,0, 1,0, 0,1, 0,1, 0),
    SDSS_1133(989, 3, "000000", false, true, 0,1, 0,1, 0,1, 1,1, 0),
    
    ;
    private final int id;
    
    // location in axial coordinants
    private int q;
    private int r;
    
	private int value;
    private int artifacts = 0;
	private String wormholes;
	private boolean centerWormhole = false;
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
	

	private Sector(int id, int value, String wormholes, boolean discoveryTile,
	        boolean artifact, int brown, int advBrown, int pink, int advPink,
	        int orange, int advOrange, int white, int advWhite, int interceptors) {
        this.id = id;
		this.value = value;
		this.wormholes = wormholes;
		this.discoveryTile = discoveryTile;
		
        worlds = new ArrayList<World>();
		if (brown > 0 || advBrown > 0) {
		    worlds.add(new World(WorldType.BROWN, brown, advBrown));
		}
		if (pink > 0 || advPink > 0) {
		    worlds.add(new World(WorldType.PINK, pink, advPink));
		}
		if (orange > 0 || advOrange > 0) {
		    worlds.add(new World(WorldType.ORANGE, orange, advOrange));
		}
		if (white > 0 || advWhite > 0) {
		    worlds.add(new World(WorldType.WHITE, white, advWhite));
		}
		
        ancientShips = new ArrayList<AncientShip>();
        for (int i = 0; i < interceptors; i++) {
            ancientShips.add(new AncientInterceptor());
        }
        
		if (artifact) {
		    artifacts = 1;
		}
		
		// init center wormhole sectors
		if (id == 281 || id == 381 || id == 382) {
		    centerWormhole = true;
		}
		
		// init ancient homeworlds
		if (id >= 271 && id <= 274) {
		    ancientShips.add(new AncientCruiser());
		}
		
		// init exile's special world
		if (id == 234) {
		    worlds.add(new World(WorldType.ORBITAL, 1, 0));
		}
		
		// TODO do something special for hive sectors? id 212 and 319
		
		// init nebula sectors
		if (id == 295 || id == 395) {
		    this.setNebula();
		}
		
		// init deep warp sectors
		if (id == 189 || id == 289 || id == 389) {
		    deepWarp = true;
		}
		
		// init warp nexus
		if (id == 989) {
	        ancientShips.add(new Anomaly(false));
	        ancientShips.add(new Anomaly(false));
	        ancientShips.add(new Anomaly(false));
	        ancientShips.add(new Anomaly(false));
		}
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
	
	public boolean isNebula() {
	    return nebula == null;
	}
	
	private void setNebula() {
	    Sector a;
	    Sector b;
	    Sector c;
	    if (id == 295) {
	        a = Sector._Nebula_Sub_A;
	        b = Sector._Nebula_Sub_B;
	        c = Sector._Nebula_Sub_E;
	    } else {
	        a = Sector._Nebula_Sub_C;
	        b = Sector._Nebula_Sub_D;
	        c = Sector._Nebula_Sub_F;
	    }
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
