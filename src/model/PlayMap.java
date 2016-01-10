package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ships.AncientShip;
import model.ships.Anomaly;
import model.ships.AncientInterceptor;

public enum PlayMap {
    Instance;
    
	private List<Sector> unplacedRing1 = new ArrayList<Sector>();
	private List<Sector> unplacedRing2 = new ArrayList<Sector>();
	private List<Sector> unplacedRing3 = new ArrayList<Sector>();
    private Set<Sector> placedSectors = new HashSet<Sector>();
	private List<ReputationTile> reputationBag = new ArrayList<ReputationTile>();
	private List<DiscoveryTile> discoveryBag = new ArrayList<DiscoveryTile>();
	private List<Technology> technologyBag = new ArrayList<Technology>();
	private List<Development> developmentBag = new ArrayList<Development>();
	private List<Evolution> evolutionBag = new ArrayList<Evolution>();
	private List<Distortion> distortionBag = new ArrayList<Distortion>();
	private Sector galacticCenter = null;
	private Sector warpNexus = null;
	
	private PlayMap() {
		initSectors();
	    galacticCenter = getGalacticCenter();
	    warpNexus = getWarpNexus();
		initReputation();
		initTechnologies();
		initDiscoveries();
		initDevelopments(true);
		
		initRiseOfAncientsDiscoveries(true);
		initManyPlayersTechnologies();
		initRiseOfAncientsTechnologies();
		initManyPlayersReputation();
		initRiseOfAncientsSectors();
		initCenterWormholeSectors();
		initHiveSectors();

        initNebulaSectors();
        initNebulaDiscoveries();
		
		initSpecialReputation();
		initEvolution();
		initDistortions();
		initShadowOfRiftSectors();
		initDeepWarpSectors();
		initShadowOfTheRiftRareTechnologies();
		initShadowOfRiftDevelopments();
		initShadowOfRiftDiscoveries();
		
        Collections.shuffle(unplacedRing1);
        Collections.shuffle(unplacedRing2);
        Collections.shuffle(unplacedRing3);
        Collections.shuffle(discoveryBag);
        Collections.shuffle(reputationBag);
        Collections.shuffle(technologyBag);
        Collections.shuffle(developmentBag);
        Collections.shuffle(evolutionBag);
        Collections.shuffle(distortionBag);
        
        // max of 12 rare technologies
        int rareTechs = 0;
        do {
            rareTechs = 0;
            Technology firstRare = null;
            for (Technology tech : technologyBag) {
                if (tech.getType() == TechnologyType.Rare) {
                    rareTechs++;
                    if (firstRare == null) {
                        firstRare = tech;
                    }
                }
            }
            if (rareTechs > 12) {
                technologyBag.remove(firstRare);
            }
        } while (rareTechs > 12);
        Collections.shuffle(technologyBag);
        
        // TODO: max developments = 1 + number of players
	}
	
	public Set<Sector> getPlacedSectors() {
	    return placedSectors;
	}
	
	public Sector getSector(int q, int r) {
	    //TODO
	    return null;
	}
	
	public Sector getNexus() {
	    return warpNexus;
	}
	
	private void initDiscoveries() {
	    for (int i = 0; i < 3; i++) {
	        discoveryBag.add(DiscoveryTile.Money);
            discoveryBag.add(DiscoveryTile.Science);
            discoveryBag.add(DiscoveryTile.Materials);
            discoveryBag.add(DiscoveryTile.Ancient_Technology);
            discoveryBag.add(DiscoveryTile.Ancient_Cruiser);
	    }
        discoveryBag.add(DiscoveryTile.Axon_Computer);
        discoveryBag.add(DiscoveryTile.Hypergrid_Source);
        discoveryBag.add(DiscoveryTile.Shard_Hull);
        discoveryBag.add(DiscoveryTile.Ion_Turret);
        discoveryBag.add(DiscoveryTile.Conformal_Drive);
        discoveryBag.add(DiscoveryTile.Flux_Shield);
	}
	
	private void initRiseOfAncientsDiscoveries(boolean useWarpPortal) {
	    discoveryBag.add(DiscoveryTile.Money_Science_Materials);
        discoveryBag.add(DiscoveryTile.Money_Science_Materials);
        discoveryBag.add(DiscoveryTile.Ancient_Orbital);
        discoveryBag.add(DiscoveryTile.Ancient_Orbital);
        discoveryBag.add(DiscoveryTile.Morph_Shield);
        discoveryBag.add(DiscoveryTile.Ion_Disruptor);
        discoveryBag.add(DiscoveryTile.Muon_Source);
        discoveryBag.add(DiscoveryTile.Jump_Drive);
        if (useWarpPortal) {
            discoveryBag.add(DiscoveryTile.Ancient_Warp_Portal);
        }
	}
	
	private void initNebulaDiscoveries() {
	    discoveryBag.add(DiscoveryTile.Ancient_Monolith);
	}
	
	private void initShadowOfRiftDiscoveries() {
	    discoveryBag.add(DiscoveryTile.Plasma_Turret);
        discoveryBag.add(DiscoveryTile.Soliton_Turret);
        discoveryBag.add(DiscoveryTile.Rift_Turret);
        discoveryBag.add(DiscoveryTile.Inversion_Shield);
        discoveryBag.add(DiscoveryTile.Rapid_Mutation);
        discoveryBag.add(DiscoveryTile.Accelerated_Evolution);
        discoveryBag.add(DiscoveryTile.Transmatter_Quantifier);
        discoveryBag.add(DiscoveryTile.Rift_Orbital);
        discoveryBag.add(DiscoveryTile.Rift_Movement);
	}
	
	private void initDevelopments(boolean useWarpPortal) {
	    developmentBag.add(Development.Ancient_Monument);
        developmentBag.add(Development.Artifact_Link);
        developmentBag.add(Development.Diplomatic_Fleet);
        developmentBag.add(Development.Mining_Colony);
        developmentBag.add(Development.Research_Station);
        developmentBag.add(Development.Trade_Fleet);
        developmentBag.add(Development.Shellworld);
        if (useWarpPortal) {
            developmentBag.add(Development.Warp_Portal);
        }
	}
	
	private void initShadowOfRiftDevelopments() {
        developmentBag.add(Development.Quantum_Labs);
        developmentBag.add(Development.Ancient_Labs);
        developmentBag.add(Development.Genetics_Labs);
	}
	
	private void initTechnologies() {
	    for (int i = 0; i < 5; i++){
	        technologyBag.add(Technology.Neutron_Bombs);
            technologyBag.add(Technology.Starbase);
            technologyBag.add(Technology.Plasma_Cannon);
            technologyBag.add(Technology.Gauss_Shield);
            technologyBag.add(Technology.Improved_Hull);
            technologyBag.add(Technology.Fusion_Source);
            technologyBag.add(Technology.Nanorobots);
            technologyBag.add(Technology.Fusion_Drive);
            technologyBag.add(Technology.Advanced_Robotics);
	    }
        for (int i = 0; i < 4; i++){
            technologyBag.add(Technology.Phase_Shield);
            technologyBag.add(Technology.Advanced_Mining);
            technologyBag.add(Technology.Positron_Computer);
            technologyBag.add(Technology.Advanced_Economy);
            technologyBag.add(Technology.Orbital);
            technologyBag.add(Technology.Advanced_Labs);
        }
        for (int i = 0; i < 3; i++){
            technologyBag.add(Technology.Tachyon_Source);
            technologyBag.add(Technology.Plasma_Missile);
            technologyBag.add(Technology.Gluon_Computer);
            technologyBag.add(Technology.Tachyon_Drive);
            technologyBag.add(Technology.Antimatter_Cannon);
            technologyBag.add(Technology.Quantum_Grid);
            technologyBag.add(Technology.Monolith);
            technologyBag.add(Technology.Artifact_Key);
            technologyBag.add(Technology.Wormhole_Generator);
        }
	}
	
	private void initManyPlayersTechnologies() {
	    for (Technology tech : Technology.values()) {
	        if (tech.getType() == TechnologyType.Rare || tech.getDefaultCost() == 2 ||
	                tech == Technology.Starbase || tech == Technology.Tachyon_Drive || tech == Technology.Artifact_Key) {
	            continue;
	        }
	        technologyBag.add(tech);
	    }
	}
	
	private void initRiseOfAncientsTechnologies() {
	    technologyBag.add(Technology.Antimatter_Splitter);
        technologyBag.add(Technology.Distortion_Shield);
        technologyBag.add(Technology.Cloaking_Device);
        technologyBag.add(Technology.Point_Defence);
        technologyBag.add(Technology.Conifold_Field);
        technologyBag.add(Technology.Sentient_Hull);
        technologyBag.add(Technology.Interceptor_Bay);
        technologyBag.add(Technology.Flux_Missile);
        technologyBag.add(Technology.Zero_Point_Source);
	}
	
	private void initShadowOfTheRiftRareTechnologies() {
	    technologyBag.add(Technology.Absorption_Shield);
        technologyBag.add(Technology.Advanced_Genetics);
        technologyBag.add(Technology.Metasynthesis);
        technologyBag.add(Technology.Rift_Cannon);
        technologyBag.add(Technology.Soliton_Cannon);
        technologyBag.add(Technology.Transition_Drive);
	}
	
	private void initReputation() {
	    for (int i = 0; i < 4; i++) {
	        reputationBag.add(new ReputationTile(ReputationTileType.Points, 4));
	    }
        for (int i = 0; i < 7; i++) {
            reputationBag.add(new ReputationTile(ReputationTileType.Points, 3));
        }
        for (int i = 0; i < 9; i++) {
            reputationBag.add(new ReputationTile(ReputationTileType.Points, 2));
        }
        for (int i = 0; i < 12; i++) {
            reputationBag.add(new ReputationTile(ReputationTileType.Points, 1));
        }
	}
	
	private void initManyPlayersReputation() {
	    // two of each plus an extra three
	    for (int j = 1; j < 3; j++) {
	        for (int i = 1; i < 5; i++) {
	            reputationBag.add(new ReputationTile(ReputationTileType.Points, i));
	        }
	    }
        reputationBag.add(new ReputationTile(ReputationTileType.Points, 3));
	}
	
	private void initSpecialReputation() {
	    reputationBag.add(new ReputationTile(ReputationTileType.Advanced_Reaction, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Bonus_Build, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Bonus_Move, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Bonus_Targeting, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Bonus_Upgrade, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Double_Action, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Priority_Action, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Re_Roll, 0));
        reputationBag.add(new ReputationTile(ReputationTileType.Resource_Gain, 0));
	}
	
	private void initEvolution() {
	    for (int i = 0; i < 2; i++) { // two each of these
	        evolutionBag.add(Evolution.Extra_Build);
	        evolutionBag.add(Evolution.Extra_Reputation_Draw);
	        evolutionBag.add(Evolution.Extra_Research);
	        evolutionBag.add(Evolution.Extra_Move);
	        evolutionBag.add(Evolution.Extra_Evolution);
	        evolutionBag.add(Evolution.VP_Evolution);
	        evolutionBag.add(Evolution.Extra_Upgrade);
	    }
        evolutionBag.add(Evolution.Extra_Upgrade); // three of this one
        evolutionBag.add(Evolution.Extra_Colony_Ship);
        evolutionBag.add(Evolution.Extra_Reputation_Ambassidor_Slot);
        evolutionBag.add(Evolution.Cheap_Interceptor);
        evolutionBag.add(Evolution.Cheap_Cruiser);
        evolutionBag.add(Evolution.Cheap_Dreadnought);
        evolutionBag.add(Evolution.Cheap_Orbital);
        evolutionBag.add(Evolution.Cheap_Monolith);
        evolutionBag.add(Evolution.Additional_Brown);
        evolutionBag.add(Evolution.Additional_Orange);
        evolutionBag.add(Evolution.Additional_Pink);
        evolutionBag.add(Evolution.Trading_Brown);
        evolutionBag.add(Evolution.Trading_Orange);
        evolutionBag.add(Evolution.Trading_Pink);
        evolutionBag.add(Evolution.VP_Artifact);
        evolutionBag.add(Evolution.VP_Orbital);
        evolutionBag.add(Evolution.VP_Monolith);
        evolutionBag.add(Evolution.VP_Galactic_Center);
        evolutionBag.add(Evolution.VP_Reputation);
        evolutionBag.add(Evolution.VP_Sectors);
	}
	
	private void initDistortions() {
	    distortionBag.add(new Distortion(DistortionType.To_Ship, 1));
        distortionBag.add(new Distortion(DistortionType.To_Ship, 2));
        distortionBag.add(new Distortion(DistortionType.To_Ships, 1));
        distortionBag.add(new Distortion(DistortionType.To_Ships, 2));
        distortionBag.add(new Distortion(DistortionType.To_Starbase, 1));
        distortionBag.add(new Distortion(DistortionType.To_Starbase, 2));
        distortionBag.add(new Distortion(DistortionType.To_Explore, 2));
        distortionBag.add(new Distortion(DistortionType.To_Explore, 3));
        distortionBag.add(new Distortion(DistortionType.From_Action, 1));
        distortionBag.add(new Distortion(DistortionType.From_Action, 2));
        distortionBag.add(new Distortion(DistortionType.From_Orbital, 3));
        distortionBag.add(new Distortion(DistortionType.From_Orbital, 3));
        distortionBag.add(new Distortion(DistortionType.From_Starbase, 2));
        distortionBag.add(new Distortion(DistortionType.From_Starbase, 2));
        distortionBag.add(new Distortion(DistortionType.From_Cruiser, 2));
        distortionBag.add(new Distortion(DistortionType.From_Cruiser, 3));
        distortionBag.add(new Distortion(DistortionType.From_Dreadnought, 2));
        distortionBag.add(new Distortion(DistortionType.From_Dreadnought, 3));
        distortionBag.add(new Distortion(DistortionType.From_Five_Six_Pink, 1));
        distortionBag.add(new Distortion(DistortionType.From_Five_Seven_Pink, 2));
        distortionBag.add(new Distortion(DistortionType.From_Five_Eight_Brown, 3));
        distortionBag.add(new Distortion(DistortionType.From_Five_Eight_Orange, 3));
        distortionBag.add(new Distortion(DistortionType.From_Plasma_Missile, 3));
        distortionBag.add(new Distortion(DistortionType.From_Gluon_Computer, 3));
        distortionBag.add(new Distortion(DistortionType.From_Tachyon_Drive, 3));
        distortionBag.add(new Distortion(DistortionType.From_Tachyon_Source, 2));
        distortionBag.add(new Distortion(DistortionType.From_Positron_Computer, 1));
	}
	
	private void initSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		// init ring 1 sectors
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing1.add(new Sector(101, "Gastor", 2, "011111", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing1.add(new Sector(102, "Pollux", 3, "101101", false, true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing1.add(new Sector(103, "Beta Leonis", 2, "111011", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		unplacedRing1.add(new Sector(104, "Arcturus", 2, "110110", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing1.add(new Sector(105, "Zeta Herculis", 3, "110111", true, true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing1.add(new Sector(106, "Capella", 2, "111100", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing1.add(new Sector(107, "Aldebaran", 2, "111101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing1.add(new Sector(108, "Mu Cassiopiae", 2, "110110", true, false, false, worlds, ships));
		
		// init ring 2
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(201, "Alpha Centauri", 1, "010101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(202, "Fomalhaut", 1, "010101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		unplacedRing2.add(new Sector(203, "Chi Draconis", 1, "110101", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing2.add(new Sector(204, "Vega", 2, "110101", true, true, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(205, "Mu Herculis", 1, "001110", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(206, "Epsilon Indi", 1, "011101", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(207, "Zeta Reticuli", 1, "110100", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(208, "Iota Persei", 1, "101101", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(209, "Delta Eridani", 1, "110101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(210, "Psi Capricorni", 1, "100101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing2.add(new Sector(211, "Beta Aquilae", 2, "111100", true, true, false, worlds, ships));
		
		// init ring 3
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		unplacedRing3.add(new Sector(301, "Zeta Draconis", 2, "101100", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing3.add(new Sector(302, "Gamma Serpentis", 2, "100110", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing3.add(new Sector(303, "Eta Cephei", 2, "000101", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(304, "Theta Pegasi", 1, "100100", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing3.add(new Sector(305, "Lambda Serpentis", 1, "110100", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(306, "Beta Centauri", 1, "010100", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(307, "Sigma Sagittarii", 1, "101100", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(308, "Kappa Scorpii", 1, "001101", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 0, 1));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(309, "Phi Piscium", 1, "100101", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(310, "Nu Phoenicis", 1, "100100", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(311, "Canopus", 1, "101100", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(312, "Antares", 1, "110100", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(313, "Alpha Ursae Minoris", 1, "100100", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(314, "Spica", 1, "001110", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(315, "Epsilon Aurigae", 1, "100101", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(316, "Iota Carinae", 1, "110100", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(317, "Beta Crucis", 1, "000110", false, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 0, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(318, "Gamma Velorum", 1, "001100", false, false, false, worlds, ships));
	}
	
	private void initRiseOfAncientsSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing2.add(new Sector(213, "Iota Bootis", 1, "110101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		unplacedRing3.add(new Sector(320, "Nu Ophiuchi", 1, "001110", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(321, "Beta Delphini", 1, "100101", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(322, "Lambda Tauri", 1, "110100", false, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(323, "Zeta Andromedae", 1, "110101", true, false, false, worlds, ships));

		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.WHITE, 1, 0));
		ships = new ArrayList<AncientShip>();
		unplacedRing3.add(new Sector(324, "Epsilon Carinae", 2, "101101", false, true, false, worlds, ships));
	}
	
	private void initCenterWormholeSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		ships = new ArrayList<AncientShip>();
		Sector s = new Sector(281, "Delta Corvi", 2, "101101", true, false, true, worlds, ships);
		unplacedRing2.add(s);
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.PINK, 1, 0));
		ships = new ArrayList<AncientShip>();
		s = new Sector(381, "Delta Sextantis", 2, "100110", true, false, true, worlds, ships);
		unplacedRing3.add(s);
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.BROWN, 1, 0));
		ships = new ArrayList<AncientShip>();
		s = new Sector(382, "Zeta Chamaeleontis", 2, "101100", true, false, true, worlds, ships);
		unplacedRing3.add(s);
	}
	
	private void initHiveSectors() {
		List<World> worlds;
		List<AncientShip> ships;
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.PINK, 0, 1));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		unplacedRing2.add(new Sector(212, "Lambda Fornacis", 2, "111111", true, false, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 0, 1));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		worlds.add(new World(WorldType.PINK, 1, 0));
		ships = new ArrayList<AncientShip>();
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		ships.add(new AncientInterceptor());
		unplacedRing2.add(new Sector(319, "Upsilon Hydrae", 2, "111111", true, false, false, worlds, ships));
	}
	
	private void initNebulaSectors() {
	    Sector sector = new Sector(295, "NGC-5189", 0, "111111", false, false, false, new ArrayList<World>(), new ArrayList<AncientShip>());
	    sector.setNebula();
	    unplacedRing2.add(sector);
        sector = new Sector(395, "NGC-1952", 0, "111111", false, false, false, new ArrayList<World>(), new ArrayList<AncientShip>());
        sector.setNebula();
        unplacedRing3.add(sector);
	}
	
	private void initShadowOfRiftSectors() {
        List<World> worlds;
        List<AncientShip> ships;
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.ORANGE, 1, 0));
        ships = new ArrayList<AncientShip>();
        ships.add(new AncientInterceptor());
        ships.add(new AncientInterceptor());
        unplacedRing1.add(new Sector(109, "Alpha Lacertae", 4, "011111", true, false, false, worlds, ships));
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.ORANGE, 0, 1));
        worlds.add(new World(WorldType.WHITE, 0, 1));
        ships = new ArrayList<AncientShip>();
        unplacedRing1.add(new Sector(110, "Iota Bootis", 2, "101110", true, false, false, worlds, ships));
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.BROWN, 0, 1));
        worlds.add(new World(WorldType.PINK, 1, 0));
        worlds.add(new World(WorldType.WHITE, 0, 1));
        ships = new ArrayList<AncientShip>();
        ships.add(new AncientInterceptor());
        unplacedRing2.add(new Sector(214, "Beta Monocerotis", 1, "111011", true, false, false, worlds, ships));
	}
	
	private void initDeepWarpSectors() {
        List<World> worlds;
        List<AncientShip> ships;
        Sector sector;
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.ORANGE, 1, 0));
        worlds.add(new World(WorldType.BROWN, 1, 0));
        worlds.add(new World(WorldType.WHITE, 0, 1));
        ships = new ArrayList<AncientShip>();
        sector = new Sector(189, "Alpha Scuti", 2, "110110", false, false, false, worlds, ships);
        sector.setDeepWarp();
        unplacedRing1.add(sector);
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.PINK, 1, 0));
        worlds.add(new World(WorldType.BROWN, 1, 0));
        worlds.add(new World(WorldType.WHITE, 0, 1));
        ships = new ArrayList<AncientShip>();
        sector = new Sector(289, "Delta Scuti", 1, "010101", false, false, false, worlds, ships);
        sector.setDeepWarp();
        unplacedRing2.add(sector);
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.ORANGE, 0, 1));
        worlds.add(new World(WorldType.PINK, 1, 0));
        worlds.add(new World(WorldType.WHITE, 0, 1));
        ships = new ArrayList<AncientShip>();
        sector = new Sector(389, "Epsilon Scuti", 1, "010100", false, false, false, worlds, ships);
        sector.setDeepWarp();
        unplacedRing3.add(sector);
	}
	
	private Sector getWarpNexus() {
        List<World> worlds;
        List<AncientShip> ships;
        
        worlds = new ArrayList<World>();
        worlds.add(new World(WorldType.ORANGE, 0, 1));
        worlds.add(new World(WorldType.PINK, 0, 1));
        worlds.add(new World(WorldType.BROWN, 0, 1));
        worlds.add(new World(WorldType.WHITE, 1, 1));
        ships = new ArrayList<AncientShip>();
        ships.add(new Anomaly(false));
        ships.add(new Anomaly(false));
        ships.add(new Anomaly(false));
        ships.add(new Anomaly(false));
        return new Sector(989, "SDSS 1133", 3, "000000", false, true, false, worlds, ships);
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
		homeworldSectors.add(new Sector(271, "Omega Fornacis", 3, "110110", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 0));
		worlds.add(new World(WorldType.PINK, 0, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(272, "Sigma Hydrae", 3, "110110", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.BROWN, 1, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(273, "Theta Ophiuchi", 3, "110110", true, true, false, worlds, ships));
		
		worlds = new ArrayList<World>();
		worlds.add(new World(WorldType.ORANGE, 1, 0));
		worlds.add(new World(WorldType.PINK, 1, 1));
		ships = new ArrayList<AncientShip>();
		homeworldSectors.add(new Sector(274, "Alpha Lyncis", 3, "110110", true, true, false, worlds, ships));
		
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
		return new Sector(001, "Galactic Center", 4, "111111", true, true, false, worlds, ships);
	}
	
	private Sector getHomeworld(Player player) {
		List<World> worlds = new ArrayList<World>();
		List<AncientShip> ships = new ArrayList<AncientShip>();
		
		switch (player.getSpecies()){
		case Terran:
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            if (player.getColor() == PlayerColor.RED) {
    		    return new Sector(221, "Procyon", 3, "110110", false, true, false, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.BLUE) {
            	return new Sector(223, "Altair", 3, "110110", false, true, false, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.GREEN) {
            	return new Sector(225, "Eta Cassiopeiae", 3, "110110", false, true, false, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.YELLOW) {
            	return new Sector(227, "Sirius", 3, "110110", false, true, false, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.WHITE) {
            	return new Sector(229, "Tau Ceti", 3, "110110", false, true, false, worlds, ships);
            }
            return new Sector(231, "Delta Pavonis", 3, "110110", false, true, false, worlds, ships);
		case Magellan:
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            if (player.getColor() == PlayerColor.PURPLE) {
    		    return new Sector(233, "47 Ursae Majois", 3, "110110", false, true, false, worlds, ships);
            }
            else if (player.getColor() == PlayerColor.GREY) {
    		    return new Sector(235, "Mu Arae", 3, "110110", false, true, false, worlds, ships);
            }
		    return new Sector(237, "55 Cancri", 3, "110110", false, true, false, worlds, ships);
		case Eridani:
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
		    return new Sector(222, "Epsilon Eridani", 3, "110110", false, true, false, worlds, ships);
		case Hydran:
			worlds.add(new World(WorldType.ORANGE, 1, 0));
            worlds.add(new World(WorldType.BROWN, 0, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
		    return new Sector(224, "Beta Hydri", 3, "110110", false, true, false, worlds, ships);
		case Planta:
			worlds.add(new World(WorldType.ORANGE, 1, 0));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(226, "S1 Cygni", 3, "110110", false, true, false, worlds, ships);
		case Descendants:
			worlds.add(new World(WorldType.ORANGE, 1, 0));
			worlds.add(new World(WorldType.PINK, 1, 0));
            worlds.add(new World(WorldType.BROWN, 0, 1));
		    return new Sector(228, "Sigma Draconis", 3, "110110", false, true, false, worlds, ships);
		case Mechanema:
			worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.BROWN, 0, 1));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(230, "Lambda Aurigae", 3, "110110", false, true, false, worlds, ships);
		case Orion:
			worlds.add(new World(WorldType.ORANGE, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 0));
		    return new Sector(232, "Rigel", 3, "110110", false, true, false, worlds, ships);
		case Exiles:
			worlds.add(new World(WorldType.ORANGE, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
            worlds.add(new World(WorldType.ORBITAL, 1, 0));
		    return new Sector(234, "Eta Geminorum", 3, "110110", false, true, false, worlds, ships);
		case Rho_Indi:
			worlds.add(new World(WorldType.ORANGE, 1, 1));
		    worlds.add(new World(WorldType.PINK, 0, 1));
		    worlds.add(new World(WorldType.BROWN, 1, 0));
		    return new Sector(236, "Rho Indi", 0, "110110", false, true, false, worlds, ships);
		case Enlightened:
		    worlds.add(new World(WorldType.ORANGE, 1, 1));
            worlds.add(new World(WorldType.PINK, 1, 1));
            worlds.add(new World(WorldType.BROWN, 1, 1));
		    return new Sector(238, "Beta Lyrae", 3, "110110", false, true, false, worlds, ships);
		case Unity:
		    worlds.add(new World(WorldType.WHITE, 1, 0));
		    worlds.add(new World(WorldType.WHITE, 0, 1));
		    return new Sector(242, "Kappa Pyxidis", 3, "110110", false, true, false, worlds, ships);
		case Shapers:
		    worlds.add(new World(WorldType.PINK, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            worlds.add(new World(WorldType.ORANGE, 1, 0));
            return new Sector(244, "Zeta Doradus", 3, "110110", false, true, false, worlds, ships);
        default: // case Octantis
            worlds.add(new World(WorldType.PINK, 0, 1));
            worlds.add(new World(WorldType.BROWN, 1, 0));
            worlds.add(new World(WorldType.ORANGE, 1, 1));
            return new Sector(241, "Theta Octantis", 3, "110110", false, true, false, worlds, ships);
		}
	}
}
