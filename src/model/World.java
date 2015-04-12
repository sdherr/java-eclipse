package model;

import java.util.ArrayList;
import java.util.List;

public class World {
	private WorldType type;
	private List<PopulationSlot> slots;
	
	public World(WorldType type, int numRegularSlots, int numAdvancedSlots) {
		this.type = type;
		slots = new ArrayList<PopulationSlot>();
		for (int i=0; i < numRegularSlots; i++) {
			PopulationSlot slot = new PopulationSlot(false);
			slots.add(slot);
		}
		for (int i=0; i < numAdvancedSlots; i++) {
			PopulationSlot slot = new PopulationSlot(true);
			slots.add(slot);
		}
	}
	
	public WorldType getType() {
		return type;
	}
	
	public List<PopulationSlot> getSlots() {
		return slots;
	}
}
