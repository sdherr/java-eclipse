package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ships.Cruiser;
import model.ships.Dreadnought;
import model.ships.Interceptor;
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
	private int colonyShips;
	private int usedColonyShips = 0;
	private int influenceDisks = 13;
	private int exp = 1; // one sector on exp
	private int inf = 2; // two colony ships on inf
	private int res = 1; // one technology on res
	private int upg = 2; // two ship parts on upg
	private int bui = 2; // two ships on bui
	private int mov = 2; // two activations on mov
	private List<Interceptor> interceptors = new ArrayList<Interceptor>();
    private List<Cruiser> cruisers = new ArrayList<Cruiser>();
    private List<Dreadnought> dreadnoughts = new ArrayList<Dreadnought>();
    private List<Starbase> starbases = new ArrayList<Starbase>();
    private List<Sector> sectors = new ArrayList<Sector>();
    private Set<ShipPart> upgradableParts = new HashSet<ShipPart>();
	private TechnologyTrack militaryTrack= new TechnologyTrack(TechnologyType.Military);
    private TechnologyTrack gridTrack= new TechnologyTrack(TechnologyType.Grid);
    private TechnologyTrack nanoTrack= new TechnologyTrack(TechnologyType.Nano);
	
	public Player(PlayerSpecies species, PlayerColor color) {
	    this.species = species;
	    this.color = color;
	    upgradableParts.add(ShipPart.Hull);
        upgradableParts.add(ShipPart.Ion_Cannon);
        upgradableParts.add(ShipPart.Nuclear_Drive);
        upgradableParts.add(ShipPart.Nuclear_Source);
        upgradableParts.add(ShipPart.Electron_Computer);
	    switch (species) {
	    case Terran:
	        money = 2;
	        science = 3;
	        materials = 3;
	        tradeRate = 2;
	        colonyShips = 3;
	        mov = 3;
	        militaryTrack.add(Technology.Starbase);
	        interceptors.add(new Interceptor(this));
	        break;
	    case Descendants:
	        money = 2;
	        science = 4;
	        materials = 3;
            tradeRate = 3;
            colonyShips = 3;
            interceptors.add(new Interceptor(this));
            break;
	    case Orion:
            money = 3;
            science = 3;
            materials = 5;
            tradeRate = 4;
            colonyShips = 3;
            militaryTrack.add(Technology.Neutron_Bombs);
            gridTrack.add(Technology.Gauss_Shield);
            upgradableParts.add(ShipPart.Gauss_Shield);
            cruisers.add(new Cruiser(this));
            break;
	    case Hydran:
            money = 2;
            science = 5;
            materials = 2;
            tradeRate = 3;
            colonyShips = 3;
            res = 2;
            nanoTrack.add(Technology.Advanced_Labs);
            interceptors.add(new Interceptor(this));
            break;
	    case Planta:
            money = 4;
            science = 4;
            materials = 4;
            tradeRate = 3;
            colonyShips = 4;
            exp = 2;
            militaryTrack.add(Technology.Starbase);
            interceptors.add(new Interceptor(this));
            break;
	    case Mechanema:
            money = 3;
            science = 3;
            materials = 3;
            tradeRate = 3;
            colonyShips = 3;
            upg = 3;
            bui = 3;
            gridTrack.add(Technology.Positron_Computer);
            upgradableParts.add(ShipPart.Positron_Computer);
            interceptors.add(new Interceptor(this));
            break;
	    case Eridani:
            money = 26;
            science = 2;
            materials = 4;
            tradeRate = 3;
            colonyShips = 3;
            influenceDisks = 11;
            militaryTrack.add(Technology.Plasma_Cannon);
            gridTrack.add(Technology.Gauss_Shield);
            nanoTrack.add(Technology.Fusion_Drive);
            upgradableParts.add(ShipPart.Plasma_Cannon);
            upgradableParts.add(ShipPart.Gauss_Shield);
            upgradableParts.add(ShipPart.Fusion_Drive);
            interceptors.add(new Interceptor(this));
            break;
	    case Enlightened:
            money = 2;
            science = 4;
            materials = 3;
            tradeRate = 3;
            colonyShips = 3;
            gridTrack.add(Technology.Distortion_Shield);
            interceptors.add(new Interceptor(this));
            break;
	    case Rho_Indi:
            money = 2;
            science = 3;
            materials = 3;
            tradeRate = 3;
            colonyShips = 2;
            mov = 4;
            militaryTrack.add(Technology.Starbase);
            gridTrack.add(Technology.Gauss_Shield);
            upgradableParts.add(ShipPart.Gauss_Shield);
            interceptors.add(new Interceptor(this));
            interceptors.add(new Interceptor(this));
            break;
	    case Exiles:
            money = 3;
            science = 2;
            materials = 4;
            tradeRate = 3;
            colonyShips = 3;
            militaryTrack.add(Technology.Cloaking_Device);
            nanoTrack.add(Technology.Orbital);
            interceptors.add(new Interceptor(this));
            break;
	    case Magellan:
            money = 2;
            science = 2;
            materials = 3;
            tradeRate = 3;
            colonyShips = 3;
            inf = 1;
            gridTrack.add(Technology.Fusion_Source);
            upgradableParts.add(ShipPart.Fusion_Source);
            interceptors.add(new Interceptor(this));
            break;
	    }
	}

	public PlayerColor getColor() {
		return color;
	}
	
	public PlayerSpecies getSpecies() {
		return species;
	}
	
	public boolean hasResearched(Technology tech) {
	    return militaryTrack.contains(tech) || gridTrack.contains(tech) || nanoTrack.contains(tech);
	}
	
	private boolean canResearch(Technology tech) {
	    return militaryTrack.canAdd(tech) || gridTrack.canAdd(tech) || nanoTrack.canAdd(tech);
	}
	
	private int minResearchCost(Technology tech) {
	    int minCost = 100; // large enough to be ridiculous
	    if (militaryTrack.canAdd(tech)) {
	        minCost = militaryTrack.cost(tech);
	    }
	    if (gridTrack.canAdd(tech) && gridTrack.cost(tech) < minCost) {
	        minCost = gridTrack.cost(tech);
	    }
	    if (nanoTrack.canAdd(tech) && nanoTrack.cost(tech) < minCost) {
	        minCost = nanoTrack.cost(tech);
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
	
	// TODO proper error handling
	public void research(Technology tech, TechnologyType type) {
	    if (type == TechnologyType.Military) {
	        science -= militaryTrack.cost(tech);
	        militaryTrack.add(tech);
	    }
	    else if (type == TechnologyType.Grid) {
            science -= gridTrack.cost(tech);
	        gridTrack.add(tech);
	    }
	    else {
	        nanoTrack.add(tech);
            science -= nanoTrack.cost(tech);
	    }
	    
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
	
    private int getShipCost(ShipType shipType) {
        if (shipType == ShipType.Interceptor) {
            if (species == PlayerSpecies.Mechanema) {
                return 2;
            }
            if (species == PlayerSpecies.Rho_Indi) {
                return 4;
            }
            return 3;
        }
        else if (shipType == ShipType.Cruiser) {
            if (species == PlayerSpecies.Mechanema) {
                return 4;
            }
            if (species == PlayerSpecies.Rho_Indi) {
                return 6;
            }
            return 5;
        }
        else if (shipType == ShipType.Dreadnought) {
            if (species == PlayerSpecies.Mechanema) {
                return 7;
            }
            return 8;
        }
        else if (shipType == ShipType.Starbase) {
            if (species == PlayerSpecies.Mechanema) {
                return 2;
            }
            if (species == PlayerSpecies.Rho_Indi) {
                return 4;
            }
            return 3;
        }
        else if (shipType == ShipType.Orbital) {
            if (species == PlayerSpecies.Mechanema) {
                return 4;
            }
            if (species == PlayerSpecies.Exiles) {
                return 6;
            }
            return 5;
        }
        else { // shipType == Monolith
            if (species == PlayerSpecies.Mechanema) {
                return 8;
            }
            return 10;
        }
    }
    
    private boolean hasEmptyOrbitalSector() {
        for (Sector sector : sectors) {
            if (!sector.hasOrbital()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasEmptyMonolithSector() {
        for (Sector sector : sectors) {
            if (!sector.hasMonolith()) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Given technologies and already built ships and controlled sectors only.
     * Not counting cost.
     */
    private boolean canBuild(ShipType shipType) {
        if (shipType == ShipType.Interceptor) {
            return interceptors.size() < 8;
        }
        if (shipType == ShipType.Cruiser) {
            return cruisers.size() < 4;
        }
        if (shipType == ShipType.Dreadnought) {
            if (species == PlayerSpecies.Rho_Indi) {
                return false;
            }
            else {
                return dreadnoughts.size() < 2;
            }
        }
        else if (shipType == ShipType.Starbase) {
            if (species == PlayerSpecies.Exiles) {
                return false;
            }
            else {
                return hasResearched(Technology.Starbase);
            }
        }
        else if (shipType == ShipType.Orbital) {
            return hasResearched(Technology.Orbital) && hasEmptyOrbitalSector();
        }
        else if (shipType == ShipType.Monolith) {
            return hasResearched(Technology.Monolith) && hasEmptyMonolithSector();
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
	
	public int getVictoryPoints() {
	    return militaryTrack.getVP() + gridTrack.getVP() + nanoTrack.getVP();
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
