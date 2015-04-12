package model;

public class PopulationSlot {
	private boolean empty;
	private boolean advanced;
	
	public PopulationSlot(boolean advanced) {
		this.empty = true;
		this.advanced = advanced;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public boolean isAdvanced() {
		return advanced;
	}
	public void setAdvanced(boolean advanced) {
		this.advanced = advanced;
	}
}
