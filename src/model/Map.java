package model;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private List<Sector> unassignedRing1;
	private List<Sector> unassignedRing2;
	private List<Sector> unassignedRing3;
	
	public Map() {
		initSectors();
	}
	
	private void initSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		// init ring 1 sectors
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing1.add(new Sector(101, "Gastor", 2, "011111", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing1.add(new Sector(102, "Pollux", 3, "101101", false, true, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing1.add(new Sector(103, "Beta Leonis", 2, "111011", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		unassignedRing1.add(new Sector(104, "Arcturus", 2, "110110", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing1.add(new Sector(105, "Zeta Herculis", 3, "110111", true, true, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing1.add(new Sector(106, "Capella", 2, "111100", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing1.add(new Sector(107, "Aldebaran", 2, "111101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing1.add(new Sector(108, "Mu Cassiopiae", 2, "110110", true, false, worlds, ships));
		
		// init ring 2
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(201, "Alpha Centauri", 1, "010101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(202, "Fomalhaut", 1, "010101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		unassignedRing2.add(new Sector(203, "Chi Draconis", 1, "110101", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing2.add(new Sector(204, "Vega", 2, "110101", true, true, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(205, "Mu Herculis", 1, "001110", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(206, "Epsilon Indi", 1, "011101", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(207, "Zeta Reticuli", 1, "110100", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(208, "Iota Persei", 1, "101101", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(209, "Delta Eridani", 1, "110101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(210, "Psi Capricorni", 1, "100101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing2.add(new Sector(211, "Beta Aquilae", 2, "111100", true, true, worlds, ships));
		
		// init ring 3
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		unassignedRing3.add(new Sector(301, "Zeta Draconis", 2, "101100", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing3.add(new Sector(302, "Gamma Serpentis", 2, "100110", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing3.add(new Sector(303, "Eta Cephei", 2, "000101", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(304, "Theta Pegasi", 1, "100100", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing3.add(new Sector(305, "Lambda Serpentis", 1, "110100", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(306, "Beta Centauri", 1, "010100", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(307, "Sigma Sagittarii", 1, "101100", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(308, "Kappa Scorpii", 1, "001101", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(309, "Phi Piscium", 1, "100101", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(310, "Nu Phoenicis", 1, "100100", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(311, "Canopus", 1, "101100", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(312, "Antares", 1, "110100", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(313, "Alpha Ursae Minoris", 1, "100100", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(314, "Spica", 1, "001110", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(315, "Epsilon Aurigae", 1, "100101", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(316, "Iota Carinae", 1, "110100", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(317, "Beta Crucis", 1, "000110", false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(318, "Gamma Velorum", 1, "001100", false, false, worlds, ships));
	}
	
	private void initAdditionalSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing2.add(new Sector(213, "Iota Bootis", 1, "110101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		unassignedRing3.add(new Sector(320, "Nu Ophiuchi", 1, "001110", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(321, "Beta Delphini", 1, "100101", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(322, "Lambda Tauri", 1, "110100", false, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(323, "Zeta Andromedae", 1, "110101", true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unassignedRing3.add(new Sector(324, "Epsilon Carinae", 2, "101101", false, true, worlds, ships));
	}
	
	private void initCenterWormholeSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		Sector s = new Sector(281, "Delta Corvi", 2, "101101", true, false, worlds, ships);
		s.setCenterWormhole();
		unassignedRing2.add(s);
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		ships = new ArrayList<AncientShip>();
		s = new Sector(381, "Delta Sextantis", 2, "100110", true, false, worlds, ships);
		s.setCenterWormhole();
		unassignedRing3.add(s);
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		s = new Sector(382, "Zeta Chamaeleontis", 2, "101100", true, false, worlds, ships);
		s.setCenterWormhole();
		unassignedRing3.add(s);
	}
	
	private void initHiveSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.PINK, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		unassignedRing2.add(new Sector(212, "Lambda Fornacis", 2, "111111", true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.PINK, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		ships.add(new BasicAncientShip());
		unassignedRing2.add(new Sector(319, "Upsilon Hydrae", 2, "111111", true, false, worlds, ships));
	}

	// TODO: Add Ancient ships
	private List<Sector> getAncientHomeworlds() {
		List<Sector> homeworldSectors = new ArrayList<Sector>();
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		worlds.add(new World(WorldType.PINK, 1, 0));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(271, "Omega Fornacis", 3, "110110", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		worlds.add(new World(WorldType.PINK, 0, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(272, "Sigma Hydrae", 3, "110110", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(273, "Theta Ophiuchi", 3, "110110", true, true, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(274, "Alpha Lyncis", 3, "110110", true, true, worlds, ships));
		
		return homeworldSectors;
	}
	
	// TODO: add GCDS
	private Sector getGalacticCenter() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 2, 0));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		return new Sector(001, "Galactic Center", 4, "111111", true, true, worlds, ships);
	}
	
	private Sector getHomeworld(Player player) {
		List<World> worlds = new ArrayList<World>();
		List<AncientShip> ships = new ArrayList<AncientShip>();
		
		if (player.getSpecies() == PlayerSpecies.Terran) {
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            if (player.getColor() == PlayerColor.RED) {
    		    return new Sector(221, "Procyon", 3, "110110", false, true, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.BLUE) {
            	return new Sector(223, "Altair", 3, "110110", false, true, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.GREEN) {
            	return new Sector(225, "Eta Cassiopeiae", 3, "110110", false, true, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.YELLOW) {
            	return new Sector(227, "Sirius", 3, "110110", false, true, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.WHITE) {
            	return new Sector(229, "Tau Ceti", 3, "110110", false, true, worlds, ships);
            }
            return new Sector(231, "Delta Pavonis", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Magellan) {
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            if (player.getColor() == PlayerColor.PURPLE) {
    		    return new Sector(233, "47 Ursae Majois", 3, "110110", false, true, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.GREY) {
    		    return new Sector(235, "Mu Arae", 3, "110110", false, true, worlds, ships);
            }
		    return new Sector(237, "55 Cancri", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Eridani) {
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
		    return new Sector(222, "Epsilon Eridani", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Hydran) {
			worlds.add(new World(WorldType.ORANGE, 1, 0));
            worlds.add(new World(WorldType.BROWN, 0, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
		    return new Sector(224, "Beta Hydri", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Planta) {
			worlds.add(new World(WorldType.ORANGE, 1, 0));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(226, "S1 Cygni", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Descendants) {
			worlds.add(new World(WorldType.ORANGE, 1, 0));
			worlds.add(new World(WorldType.PINK, 1, 0));
            worlds.add(new World(WorldType.BROWN, 0, 1));
		    return new Sector(228, "Sigma Draconis", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Mechanema) {
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.BROWN, 0, 1));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(230, "Lambda Aurigae", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Orion) {
			worlds.add(new World(WorldType.ORANGE, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(232, "Rigel", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Exiles) {
			// TODO: add orbital
			worlds.add(new World(WorldType.ORANGE, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
		    return new Sector(234, "Eta Geminorum", 3, "110110", false, true, worlds, ships);
		}
		else if (player.getSpecies() == PlayerSpecies.Rho_Indi) {
			worlds.add(new World(WorldType.ORANGE, 1, 1));
		    worlds.add(new World(WorldType.PINK, 0, 1));
		    worlds.add(new World(WorldType.BROWN, 1, 0));
		    return new Sector(236, "Rho Indi", 0, "110110", false, true, worlds, ships);
		}
		else { // if (player.getSpecies() == PlayerSpecies.Enlightened) {
		    worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
		    return new Sector(238, "Beta Lyrae", 3, "110110", false, true, worlds, ships);
		}
	}
}
