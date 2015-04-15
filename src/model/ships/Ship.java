package model.ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Die;
import model.Player;
import model.PlayerColor;

public abstract class Ship {
	private int damage;
	private int hull;
	private int initiative;
	private List<Die> guns;
	private List<Die> missiles;
	private int computers;
	private int shields;
	private int drive;
	private int power;
	private int interceptorBays;
	private int regeneration;
	private Player player;
	private Map<Integer, ShipPart> blueprint;
	
	// arguemntless constructor automatically called
	// all ships want their changeable blueprint to start out as the initial blueprint
	protected Ship() {
	    blueprint = new HashMap<Integer, ShipPart>(getInitialBlueprint());
	    try {
            recalculateShipAttributes();
        }
        catch (Exception e) {
            // should never happen...
            e.printStackTrace();
        }
	}
	
	protected abstract Map<Integer, ShipPart> getInitialBlueprint();
	protected abstract int getInherentInitiative();
	protected abstract int getInherentPower();
	public abstract int reputationDraws();
	
	protected int getInherentShields() {
	    return 0;
	}
	
	protected int getInherentHull() {
	    return 1;
	}
	
	protected int getInherentComputers() {
	    return 0;
	}
	
	protected boolean shipCanHaveDrive() {
	    return true;
	}
	
	public int getVictoryPointValue() {
	    return 0;
	}
	
	public int getNumModifiableSlots() {
	    return 0;
	}
	
	public void removeShipPart(Integer position) throws Exception {
	    ShipPart oldPart = blueprint.get(position);
	    blueprint.put(position, getInitialBlueprint().get(position));
	    try {
	        recalculateShipAttributes();
	    }
	    catch (Exception e) {
	        blueprint.put(position, oldPart);
	        recalculateShipAttributes();
	        throw e;
	    }
	}
	
	public void placeShipPart(Integer position, ShipPart part) throws Exception {
	    ShipPart oldPart = blueprint.get(position);
	    blueprint.put(position, part);
	    try {
	        recalculateShipAttributes();
	    }
	    catch (Exception e) {
	        blueprint.put(position, oldPart);
	        recalculateShipAttributes();
	        throw e;
	    }
	}
	
	private void recalculateShipAttributes() throws Exception {
	    int power = getInherentPower();
	    int initiative = getInherentInitiative();
	    int shields = getInherentShields();
	    int computers = getInherentComputers();
	    int hull = getInherentHull();
	    int drives = 0;
	    int interceptorBays = 0;
	    int regeneration = 0;
	    List<Die> guns = new ArrayList<Die>();
	    List<Die> missiles = new ArrayList<Die>();
	    
	    for (ShipPart part : blueprint.values()) {
	        power += part.getPower();
	        initiative += part.getInitiative();
	        shields += part.getShields();
	        computers += part.getComputers();
	        hull += part.getHull();
	        drives += part.getDrives();
            interceptorBays += part.getInterceptorBays();
            regeneration += part.getRegeneration();
	        guns.addAll(part.getDice());
	        missiles.addAll(part.getMissileDice());
	    }
	    
	    if (power < 0) {
	        throw new NotEnoughPowerException();
	    }
	    if (shipCanHaveDrive() && drives == 0) {
	        throw new MissingDriveException();
	    }
	    if (!shipCanHaveDrive() && drives != 0) {
	        throw new CannotPlaceDriveException();
	    }
	    
	    this.power = power;
	    this.initiative = initiative;
	    this.shields = shields;
	    this.computers = computers;
	    this.hull = hull;
	    this.drive = drives;
	    this.interceptorBays = interceptorBays;
	    this.regeneration = regeneration;
	    this.guns = guns;
	    this.missiles = missiles;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getHealth() {
		return hull;
	}
	
	public int getInitiative() {
		return initiative;
	}

	public List<Die> getGuns() {
		return guns;
	}

	public List<Die> getMissiles() {
		return missiles;
	}

	public int getComputers() {
		return computers;
	}
	
	public int getShields() {
		return shields;
	}
	
	public int getDrive() {
		return drive;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getInterceptorBays() {
	    return interceptorBays;
	}
	
	public int getRegeneration() {
	    return regeneration;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public PlayerColor getColor() {
		return player.getColor();
	}
	
	public Map<Integer, ShipPart> getBlueprint() {
	    return blueprint;
	}
}
