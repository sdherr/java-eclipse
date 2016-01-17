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
		// init ring 1 sectors
		unplacedRing1.add(Sector.Gastor);
		unplacedRing1.add(Sector.Pollux);
		unplacedRing1.add(Sector.Beta_Lenois);
		unplacedRing1.add(Sector.Arcturus);
		unplacedRing1.add(Sector.Zeta_Herculis);
		unplacedRing1.add(Sector.Capella);
		unplacedRing1.add(Sector.Aldebaran);
		unplacedRing1.add(Sector.Mu_Cassiopiae);
		
		// init ring 2
		unplacedRing2.add(Sector.Alpha_Centauri);
		unplacedRing2.add(Sector.Fomalhaut);
		unplacedRing2.add(Sector.Chi_Draconis);
		unplacedRing2.add(Sector.Vega);
		unplacedRing2.add(Sector.Mu_Herculis);
		unplacedRing2.add(Sector.Epsilon_Indi);
		unplacedRing2.add(Sector.Zeta_Reticuli);
		unplacedRing2.add(Sector.Iota_Persei);
		unplacedRing2.add(Sector.Delta_Eridani);
		unplacedRing2.add(Sector.Psi_Capricorni);
		unplacedRing2.add(Sector.Beta_Aquilae);
		
		// init ring 3
		unplacedRing3.add(Sector.Zeta_Draconis);
		unplacedRing3.add(Sector.Gamma_Serpentis);
		unplacedRing3.add(Sector.Eta_Cephei);
		unplacedRing3.add(Sector.Theta_Pegasi);
		unplacedRing3.add(Sector.Lambda_Serpentis);
		unplacedRing3.add(Sector.Beta_Centauri);
		unplacedRing3.add(Sector.Sigma_Sagittarii);
		unplacedRing3.add(Sector.Kappa_Scorpii);
		unplacedRing3.add(Sector.Phi_Piscium);
		unplacedRing3.add(Sector.Nu_Phoenicis);
		unplacedRing3.add(Sector.Canopus);
		unplacedRing3.add(Sector.Antares);
		unplacedRing3.add(Sector.Alpha_Ursae_Minoris);
		unplacedRing3.add(Sector.Spica);
		unplacedRing3.add(Sector.Epsilon_Aurigae);
		unplacedRing3.add(Sector.Iota_Carinae);
		unplacedRing3.add(Sector.Beta_Crucis);
		unplacedRing3.add(Sector.Gamma_Velorum);
	}
	
	private void initRiseOfAncientsSectors() {
		unplacedRing2.add(Sector.Iota_Bootis);
		unplacedRing3.add(Sector.Nu_Ophiuchi);
		unplacedRing3.add(Sector.Beta_Delphini);
		unplacedRing3.add(Sector.Lambda_Tauri);
		unplacedRing3.add(Sector.Zeta_Andromedae);
		unplacedRing3.add(Sector.Epsilon_Carinae);
	}
	
	private void initCenterWormholeSectors() {
		unplacedRing2.add(Sector.Delta_Corvi);
		unplacedRing3.add(Sector.Delta_Sextantis);
		unplacedRing3.add(Sector.Zeta_Chamaeleontis);
	}
	
	private void initHiveSectors() {
		unplacedRing2.add(Sector.Lambda_Fornacis);
		unplacedRing3.add(Sector.Upsilon_Hydrae);
	}
	
	private void initNebulaSectors() {
	    unplacedRing2.add(Sector.NGC_5189);
        unplacedRing3.add(Sector.NGC_1952);
	}
	
	private void initShadowOfRiftSectors() {
        unplacedRing1.add(Sector.Alpha_Lacertae);
        unplacedRing1.add(Sector.Gamma_Bootis);
        unplacedRing2.add(Sector.Beta_Monocerotis);
	}
	
	private void initDeepWarpSectors() {
        unplacedRing1.add(Sector.Alpha_Scuti);
        unplacedRing2.add(Sector.Delta_Scuti);
        unplacedRing3.add(Sector.Epsilon_Scuti);
	}
	
	private Sector getWarpNexus() {
	    return Sector.SDSS_1133;
	}

	private List<Sector> getAncientHomeworlds() {
		List<Sector> homeworldSectors = new ArrayList<Sector>();
		homeworldSectors.add(Sector.Omega_Fornacis);
		homeworldSectors.add(Sector.Sigma_Hydrae);
		homeworldSectors.add(Sector.Theta_Ophiuchi);
		homeworldSectors.add(Sector.Alpha_Lyncis);
		return homeworldSectors;
	}
	
	private Sector getGalacticCenter() {
	    return Sector.Galactic_Center;
	}
	
	private Sector getHomeworld(Player player) {
		switch (player.getSpecies()){
		case Terran:
            if (player.getColor() == PlayerColor.RED) {
    		    return Sector.Procyon;
            }
            else if (player.getColor() == PlayerColor.BLUE) {
            	return Sector.Altair;
            }
            else if (player.getColor() == PlayerColor.GREEN) {
            	return Sector.Eta_Cassiopeiae;
            }
            else if (player.getColor() == PlayerColor.YELLOW) {
            	return Sector.Sirius;
            }
            else if (player.getColor() == PlayerColor.WHITE) {
            	return Sector.Tau_Ceti;
            }
            return Sector.Delta_Pavonis;
		case Magellan:
            if (player.getColor() == PlayerColor.PURPLE) {
    		    return Sector.Ursae_Majois_47;
            }
            else if (player.getColor() == PlayerColor.GREY) {
    		    return Sector.Mu_Arae;
            }
		    return Sector.Cancri_55;
		case Eridani:
		    return Sector.Epsilon_Eridani;
		case Hydran:
		    return Sector.Beta_Hydri;
		case Planta:
		    return Sector.S1_Cygni;
		case Descendants:
		    return Sector.Sigma_Draconis;
		case Mechanema:
		    return Sector.Lambda_Fornacis;
		case Orion:
		    return Sector.Rigel;
		case Exiles:
		    return Sector.Eta_Geminorum;
		case Rho_Indi:
		    return Sector.Rho_Indi;
		case Enlightened:
		    return Sector.Beta_Lyrae;
		case Unity:
		    return Sector.Kappa_Pyxidis;
		case Shapers:
            return Sector.Zeta_Doradus;
        default: // case Octantis
            return Sector.Theta_Octantis; // nu_octantis is the other one
		}
	}
}
