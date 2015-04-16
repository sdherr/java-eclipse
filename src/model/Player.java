package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ships.Cruiser;
import model.ships.Dreadnought;
import model.ships.Interceptor;
import model.ships.Monolith;
import model.ships.Orbital;
import model.ships.Ship;
import model.ships.ShipBlueprint;
import model.ships.ShipPart;
import model.ships.ShipType;
import model.ships.Starbase;

public class Player {
	private PlayerColor color;
	private PlayerSpecies species;
	private int money;
	private int science;
	private int materials;
	private int tradeRate; // "x to 1"
	private int colonyShips = 3;
	private int usedColonyShips = 0;
	private int influenceDisks = 13;
	private int exp = 1; // one sector on exp
	private int inf = 2; // two colony ships on inf
	private int res = 1; // one technology on res
	private int upg = 2; // two ship parts on upg
	private int bui = 2; // two ships on bui
	private int mov = 2; // two activations on mov
	private int availableAmbassadors = 4;
	private int discoveryVP = 0;
    private List<Ship> ships = new ArrayList<Ship>();
    private List<Sector> sectors = new ArrayList<Sector>();
    private Set<ShipPart> upgradableParts = new HashSet<ShipPart>();
    private Map<ShipType, ShipBlueprint> shipBlueprints = new HashMap<ShipType, ShipBlueprint>();
    private Map<TechnologyType, TechnologyTrack> technologyTracks = new HashMap<TechnologyType, TechnologyTrack>();
    private List<Development> developments = new ArrayList<Development>();
    private List<RepAmbSlot> repAmbTrack = new ArrayList<RepAmbSlot>();
    private List<ShipPart> oneTimePlacementParts = new ArrayList<ShipPart>();
	
	public Player(PlayerSpecies species, PlayerColor color) {
	    this.species = species;
	    this.color = color;
	    upgradableParts.add(ShipPart.Hull);
        upgradableParts.add(ShipPart.Ion_Cannon);
        upgradableParts.add(ShipPart.Nuclear_Drive);
        upgradableParts.add(ShipPart.Nuclear_Source);
        upgradableParts.add(ShipPart.Electron_Computer);
        shipBlueprints.put(ShipType.Interceptor, new Interceptor(this));
        shipBlueprints.put(ShipType.Cruiser, new Cruiser(this));
        shipBlueprints.put(ShipType.Dreadnought, new Dreadnought(this));
        shipBlueprints.put(ShipType.Starbase, new Starbase(this));
        shipBlueprints.put(ShipType.Orbital, new Orbital(this));
        shipBlueprints.put(ShipType.Monolith, new Monolith(this));
        TechnologyTrack militaryTrack= new TechnologyTrack(TechnologyType.Military);
        TechnologyTrack gridTrack= new TechnologyTrack(TechnologyType.Grid);
        TechnologyTrack nanoTrack= new TechnologyTrack(TechnologyType.Nano);
        repAmbTrack.add(new RepAmbSlot(RepAmbType.Both));
        repAmbTrack.add(new RepAmbSlot(RepAmbType.Both));
        repAmbTrack.add(new RepAmbSlot(RepAmbType.Both));
        repAmbTrack.add(new RepAmbSlot(RepAmbType.Both));
        Sector startingSector = null; // TODO fix?
        
	    switch (species) {
	    case Terran:
	        money = 2;
	        science = 3;
	        materials = 3;
	        tradeRate = 2;
	        mov = 3;
	        militaryTrack.add(Technology.Starbase);
	        ships.add(new Ship(this, startingSector, ShipType.Interceptor));
	        repAmbTrack.add(0, new RepAmbSlot(RepAmbType.Ambassador_Only));
	        break;
	    case Descendants:
	        money = 2;
	        science = 4;
	        materials = 3;
            tradeRate = 3;
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    case Orion:
            money = 3;
            science = 3;
            materials = 5;
            tradeRate = 4;
            militaryTrack.add(Technology.Neutron_Bombs);
            gridTrack.add(Technology.Gauss_Shield);
            upgradableParts.add(ShipPart.Gauss_Shield);
            ships.add(new Ship(this, startingSector, ShipType.Cruiser));
            repAmbTrack.add(new RepAmbSlot(RepAmbType.Reputation_Only));
            break;
	    case Hydran:
            money = 2;
            science = 5;
            materials = 2;
            tradeRate = 3;
            res = 2;
            nanoTrack.add(Technology.Advanced_Labs);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            repAmbTrack.set(0, new RepAmbSlot(RepAmbType.Ambassador_Only));
            break;
	    case Planta:
            money = 4;
            science = 4;
            materials = 4;
            tradeRate = 3;
            colonyShips = 4;
            exp = 2;
            militaryTrack.add(Technology.Starbase);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            repAmbTrack.set(0, new RepAmbSlot(RepAmbType.Ambassador_Only));
            break;
	    case Mechanema:
            money = 3;
            science = 3;
            materials = 3;
            tradeRate = 3;
            upg = 3;
            bui = 3;
            gridTrack.add(Technology.Positron_Computer);
            upgradableParts.add(ShipPart.Positron_Computer);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    case Eridani:
            money = 26;
            science = 2;
            materials = 4;
            tradeRate = 3;
            influenceDisks = 11;
            militaryTrack.add(Technology.Plasma_Cannon);
            gridTrack.add(Technology.Gauss_Shield);
            nanoTrack.add(Technology.Fusion_Drive);
            upgradableParts.add(ShipPart.Plasma_Cannon);
            upgradableParts.add(ShipPart.Gauss_Shield);
            upgradableParts.add(ShipPart.Fusion_Drive);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    case Enlightened:
            money = 2;
            science = 4;
            materials = 3;
            tradeRate = 3;
            gridTrack.add(Technology.Distortion_Shield);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    case Rho_Indi:
            money = 2;
            science = 3;
            materials = 3;
            tradeRate = 3;
            colonyShips = 2;
            mov = 4;
            availableAmbassadors = 2;
            militaryTrack.add(Technology.Starbase);
            gridTrack.add(Technology.Gauss_Shield);
            upgradableParts.add(ShipPart.Gauss_Shield);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            repAmbTrack.set(2, new RepAmbSlot(RepAmbType.Reputation_Only));
            repAmbTrack.set(3, new RepAmbSlot(RepAmbType.Reputation_Only));
            repAmbTrack.add(new RepAmbSlot(RepAmbType.Reputation_Only));
            break;
	    case Exiles:
            money = 3;
            science = 2;
            materials = 4;
            tradeRate = 3;
            militaryTrack.add(Technology.Cloaking_Device);
            nanoTrack.add(Technology.Orbital);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    case Magellan:
            money = 2;
            science = 2;
            materials = 3;
            tradeRate = 3;
            inf = 1;
            gridTrack.add(Technology.Fusion_Source);
            upgradableParts.add(ShipPart.Fusion_Source);
            ships.add(new Ship(this, startingSector, ShipType.Interceptor));
            break;
	    }
	    
	    technologyTracks.put(TechnologyType.Military, militaryTrack);
	    technologyTracks.put(TechnologyType.Grid, gridTrack);
	    technologyTracks.put(TechnologyType.Nano, nanoTrack);
	}

	public PlayerColor getColor() {
		return color;
	}
	
	public PlayerSpecies getSpecies() {
		return species;
	}
	
	public boolean hasResearched(Technology tech) {
	    return technologyTracks.get(TechnologyType.Military).contains(tech)
	            || technologyTracks.get(TechnologyType.Grid).contains(tech)
	            || technologyTracks.get(TechnologyType.Nano).contains(tech);
	}
	
	private boolean canResearch(Technology tech) {
	    return technologyTracks.get(TechnologyType.Military).canAdd(tech)
	            || technologyTracks.get(TechnologyType.Grid).canAdd(tech)
	            || technologyTracks.get(TechnologyType.Nano).canAdd(tech);
	}
	
	private int minResearchCost(Technology tech) {
	    int minCost = 100; // large enough to be ridiculous
	    for (TechnologyType type : TechnologyType.values()) {
	        if (type == TechnologyType.Rare) {
	            continue;
	        }
	        if (technologyTracks.get(type).canAdd(tech) && technologyTracks.get(type).cost(tech) < minCost) {
	            minCost = technologyTracks.get(type).cost(tech);
	        }
	    }
	    return minCost;
	}
    
    private int maxPossibleMaterials() {
        int tmp = materials;
        tmp += science / tradeRate;
        if (species == PlayerSpecies.Rho_Indi) {
            tmp += (money / 3) * 2;
        }
        else {
            tmp += money / tradeRate;
        }
        if (species == PlayerSpecies.Magellan) {
            tmp += remainingColonyShips();
        }
        return tmp;
    }
	
	private int maxPossibleScience() {
	    int tmp = science;
	    tmp += materials / tradeRate;
	    if (species == PlayerSpecies.Rho_Indi) {
	        tmp += (money / 3) * 2;
	    }
	    else {
	        tmp += money / tradeRate;
	    }
	    if (species == PlayerSpecies.Magellan) {
	        tmp += remainingColonyShips();
	    }
	    return tmp;
	}
	
	public boolean canEasilyResearch(Technology tech) {
	    return !hasResearched(tech) && canResearch(tech) &&  minResearchCost(tech) <= science;
	}
	
	public boolean canPossiblyResearch(Technology tech) {
	    return !hasResearched(tech) && canResearch(tech) && minResearchCost(tech) <= maxPossibleScience();
	}
	
	public void research(Technology tech, TechnologyType type) {
	    if (!technologyTracks.get(type).canAdd(tech) || !canEasilyResearch(tech)) {
	        return; // TODO maybe throw an error instead of doing nothing?
	    }
	    
	    science -= technologyTracks.get(type).cost(tech);
	    technologyTracks.get(type).add(tech);
	    
	    switch (tech) {
	    case Plasma_Cannon:
	        upgradableParts.add(ShipPart.Plasma_Cannon);
	        break;
	    case Plasma_Missile:
	        upgradableParts.add(ShipPart.Plasma_Missile);
	        break;
	    case Positron_Computer:
            upgradableParts.add(ShipPart.Positron_Computer);
            break;
	    case Gluon_Computer:
            upgradableParts.add(ShipPart.Gluon_Computer);
            break;
	    case Antimatter_Cannon:
            upgradableParts.add(ShipPart.Antimatter_Cannon);
            break;
	    case Improved_Hull:
            upgradableParts.add(ShipPart.Improved_Hull);
            break;
	    case Gauss_Shield:
            upgradableParts.add(ShipPart.Gauss_Shield);
            break;
	    case Phase_Shield:
            upgradableParts.add(ShipPart.Phase_Shield);
            break;
	    case Fusion_Drive:
            upgradableParts.add(ShipPart.Fusion_Drive);
            break;
	    case Tachyon_Drive:
            upgradableParts.add(ShipPart.Tachon_Drive);
            break;
	    case Fusion_Source:
            upgradableParts.add(ShipPart.Fusion_Source);
            break;
	    case Tachyon_Source:
            upgradableParts.add(ShipPart.Tachyon_Source);
            break;
	    case Conifold_Field:
            upgradableParts.add(ShipPart.Conifold_Field);
            break;
	    case Sentient_Hull:
            upgradableParts.add(ShipPart.Sentient_Hull);
            break;
	    case Interceptor_Bay:
            upgradableParts.add(ShipPart.Interceptor_Bay);
            break;
	    case Flux_Missile:
            upgradableParts.add(ShipPart.Flux_Missile);
            break;
	    case Zero_Point_Source:
            upgradableParts.add(ShipPart.Zero_Point_Source);
            break;
	    case Advanced_Robotics:
	        influenceDisks += 1;
	        break;
	    case Quantum_Grid:
	        influenceDisks += 2;
	        break;
	    case Nanorobots:
	        bui += 1;
	        break;
	    }
	}
	
	public boolean canEasilyResearch(Development dev) {
	    return dev.getEconomyCost() <= money && dev.getMaterialsCost() <= materials && dev.getScienceCost() <= science;
	}
	
	public boolean canPossiblyResearch(Development dev) {
	    int diffMoney = money - dev.getEconomyCost();
	    int diffScience = science - dev.getScienceCost();
	    int diffMaterials = materials - dev.getMaterialsCost();
	    int extra = 0;
	    int shortfall = 0;
	    
	    if (diffMoney > 0) {
	        if (species == PlayerSpecies.Rho_Indi) {
	            extra += (diffMoney / 3) * 2;
	        }
	        else {
	            extra += diffMoney / tradeRate;
	        }
	    }
	    else {
	        shortfall += diffMoney; // adding a negative number
	    }
	    
	    if (diffScience > 0) {
	        extra += diffScience / tradeRate;
	    }
	    else {
	        shortfall += diffScience;
	    }
	    
	    if (diffMaterials > 0) {
	        extra += diffMaterials / tradeRate;
	    }
	    else {
	        shortfall += diffMaterials;
	    }
	    
	    if (species == PlayerSpecies.Magellan) {
	        extra += remainingColonyShips();
	    }
	    return extra + shortfall >= 0;
	}
	
	public void research(Development dev) {
	    if (!canEasilyResearch(dev)) {
	        return; // TODO: maybe throw an error instead?
	    }
	    
	    money -= dev.getEconomyCost();
	    science -= dev.getScienceCost();
	    materials -= dev.getMaterialsCost();
	    developments.add(dev);
	    
	    switch (dev) {
	    case Mining_Colony:
	        materials += 12;
	        break;
	    case Research_Station:
	        science += 12;
	        break;
	    case Trade_Fleet:
	        money += 12;
	        break;
	    case Diplomatic_Fleet:
	        repAmbTrack.add(new RepAmbSlot(RepAmbType.Both));
	        break;
	    default:
	        ; // TODO place shellworld and warp portal if it's those
	    }
	}
	
    private int getShipCost(ShipType shipType) {
        return shipBlueprints.get(shipType).getCost();
    }
    
    private List<Sector> listEmptyOrbitalSectors() {
        List<Sector> ret = new ArrayList<Sector>();
        for (Sector sector : sectors) {
            if (!sector.hasOrbital()) {
                ret.add(sector);
            }
        }
        return ret;
    }
    
    private List<Sector> listEmptyMonolithSectors() {
        List<Sector> ret = new ArrayList<Sector>();
        for (Sector sector : sectors) {
            if (!sector.hasMonolith()) {
                ret.add(sector);
            }
        }
        return ret;
    }
    
    /*
     * Given technologies and already built ships and controlled sectors only.
     * Not counting cost.
     */
    private boolean canBuild(ShipType shipType) {
        int numShipsBuilt = 0;
        for (Ship ship : ships) {
            if (ship.getType() == shipType) {
                numShipsBuilt += 1;
            }
        }
        if (shipType == ShipType.Interceptor) {
            return numShipsBuilt < 8;
        }
        if (shipType == ShipType.Cruiser) {
            return numShipsBuilt < 4;
        }
        if (shipType == ShipType.Dreadnought) {
            if (species == PlayerSpecies.Rho_Indi) {
                return false;
            }
            else {
                return numShipsBuilt < 2;
            }
        }
        else if (shipType == ShipType.Starbase) {
            if (species == PlayerSpecies.Exiles) {
                return false;
            }
            else {
                return numShipsBuilt < 4 && hasResearched(Technology.Starbase);
            }
        }
        else if (shipType == ShipType.Orbital) {
            return hasResearched(Technology.Orbital) && !listEmptyOrbitalSectors().isEmpty();
        }
        else if (shipType == ShipType.Monolith) {
            return hasResearched(Technology.Monolith) && !listEmptyMonolithSectors().isEmpty();
        }
        return false;
    }
	
	public boolean canEasilyBuild(ShipType shipType) {
	    return canBuild(shipType) && getShipCost(shipType) <= materials;
	}
	
	public boolean canPossiblyBuild(ShipType shipType) {
	    return canBuild(shipType) && getShipCost(shipType) <= maxPossibleMaterials();
	}
	
	public int remainingColonyShips() {
	    return colonyShips - usedColonyShips;
	}
	
	public void useDiscoveryTile(DiscoveryTile tile, boolean keepingAsVp, Sector sector) {
	    if (keepingAsVp) {
	        discoveryVP += 2;
	        return;
	    }
	    if (species == PlayerSpecies.Magellan) {
	        discoveryVP += 1;
	    }
	    switch (tile) {
	    case Money:
	        money += 8;
	        break;
	    case Science:
	        science += 5;
	        break;
	    case Materials:
	        materials += 6;
	        break;
	    case Money_Science_Materials:
	        money += 3;
	        science += 2;
	        materials += 2;
	        break;
	    case Ancient_Cruiser:
	        // TODO add ship to sector
	        break;
	    case Ancient_Technology:
	        // TODO this
	        break;
	    case Ancient_Orbital:
	        if (sector.hasOrbital()) {
	            if (species == PlayerSpecies.Magellan) {
	                discoveryVP += 1;
	            }
	            else {
	                discoveryVP += 2;
	            }
	        }
	        else {
	            sector.addOrbitalDiscovery();
	        }
	        break;
	    case Ancient_Warp_Portal:
	        sector.addWarpPortalDiscovery();
	        break;
	    case Ion_Turret:
	        oneTimePlacementParts.add(ShipPart.Ion_Turret);
	        // TODO for all these next ones call out to something maybe to enable user to place ship part immediately
	        break;
        case Conformal_Drive:
            oneTimePlacementParts.add(ShipPart.Conformal_Drive);
            break;
        case Flux_Shield:
            oneTimePlacementParts.add(ShipPart.Flux_Shield);
            break;
        case Axon_Computer:
            oneTimePlacementParts.add(ShipPart.Axion_Computer);
            break;
        case Hypergrid_Source:
            oneTimePlacementParts.add(ShipPart.Hypergrid_Source);
            break;
        case Shard_Hull:
            oneTimePlacementParts.add(ShipPart.Shard_Hull);
            break;
        case Muon_Source:
            oneTimePlacementParts.add(ShipPart.Muon_Source);
            break;
        case Morph_Shield:
            oneTimePlacementParts.add(ShipPart.Morph_Shield);
            break;
        case Ion_Disruptor:
            oneTimePlacementParts.add(ShipPart.Ion_Disruptor);
            break;
        case Jump_Drive:
            oneTimePlacementParts.add(ShipPart.Jump_Drive);
            break;
	    }
	}
	
	public int getVictoryPoints() {
	    int vp = 0;
	    for (TechnologyTrack track : technologyTracks.values()) {
	        vp += track.getVP();
	    }
	    if (developments.contains(Development.Ancient_Monument)) {
	        vp += 3;
	    }
        for (Sector sector : sectors) {
            vp += sector.getVPValue();
            if (developments.contains(Development.Artifact_Link)) {
                vp += sector.numberOfArtifacts();
            }
        }
        for (RepAmbSlot slot : repAmbTrack) {
            vp += slot.getVPValue();
        }
        vp += discoveryVP;
	    return vp;
	}
	
	private enum RepAmbType {
	    Ambassador_Only, Reputation_Only, Both;
	}
	
	private class RepAmbSlot {
	    RepAmbType type;
	    Player ambassador;
	    Integer reputationTile;
	    
	    public RepAmbSlot(RepAmbType type) {
	        this.type = type;
	    }
	    
	    public void setRepuationTile(Integer reputationTile) {
	        this.reputationTile = reputationTile;
	    }
	    
	    public Integer getReputationTile() {
	        return reputationTile;
	    }
	    
	    public void setAmbassador(Player ambassador) {
	        reputationTile = null;
	        this.ambassador = ambassador;
	    }
	    
	    public Player getAmbassador() {
	        return ambassador;
	    }
	    
	    public int getVPValue() {
	        if (ambassador != null) {
	            return 1;
	        }
	        if (reputationTile != null) {
	            return reputationTile;
	        }
	        return 0;
	    }
	}

    private class TechnologyTrack {
        private List<Technology> technologies = new ArrayList<Technology>(7);
        private TechnologyType type;
        
        public TechnologyTrack(TechnologyType type) {
            this.type = type;
        }
        
        public boolean contains(Technology tech) {
            return technologies.contains(tech);
        }
        
        public boolean canAdd(Technology tech) {
            return (tech.getType() == type || tech.getType() == TechnologyType.Rare)
                    && technologies.size() < 7 && !technologies.contains(tech);
        }
        
        public int cost(Technology tech) {
            int cost = tech.getDefaultCost();
            switch (technologies.size()) {
            case 0:
                break;
            case 1:
                cost -= 1;
                break;
            case 2:
                cost -= 2;
                break;
            case 3:
                cost -= 3;
                break;
            case 4:
                cost -= 4;
                break;
            case 5:
                cost -= 6;
                break;
            case 6:
                cost -= 8;
                break;
            }
            return cost < tech.getMinimumCost() ? tech.getMinimumCost() : cost;
        }
        
        public int getVP() {
            switch (technologies.size()) {
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 0;
            }
        }
        
        public void add(Technology tech) {
            technologies.add(tech);
        }
    }
}
