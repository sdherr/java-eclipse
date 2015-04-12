package model;

import java.util.List;

public abstract class Ship {
	private int damage;
	private int health;
	private int initiative;
	private List<Gun> guns;
	private List<Gun> missiles;
	private int computers;
	private int shields;
	private int drive;
	private int power;
	private int powerUsed;
	private Player player;
	
	public boolean isAncient() {
		return false;
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public List<Gun> getGuns() {
		return guns;
	}
	public void setGuns(List<Gun> guns) {
		this.guns = guns;
	}
	public List<Gun> getMissiles() {
		return missiles;
	}
	public void setMissiles(List<Gun> missiles) {
		this.missiles = missiles;
	}
	public int getComputers() {
		return computers;
	}
	public void setComputers(int computers) {
		this.computers = computers;
	}
	public int getShields() {
		return shields;
	}
	public void setShields(int shields) {
		this.shields = shields;
	}
	public int getDrive() {
		return drive;
	}
	public void setDrive(int drive) {
		this.drive = drive;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPowerUsed() {
		return powerUsed;
	}
	public void setPowerUsed(int powerUsed) {
		this.powerUsed = powerUsed;
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
}
