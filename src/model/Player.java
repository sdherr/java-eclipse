package model;

public class Player {
	private PlayerColor color;
	private PlayerSpecies species;

	public PlayerColor getColor() {
		return color;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}
	
	public PlayerSpecies getSpecies() {
		return species;
	}
	
	public void setSpecies(PlayerSpecies species) {
		this.species = species;
	}
}
