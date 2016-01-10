package model;

public enum Development {
    Ancient_Monument(13, 0, 0),
    Artifact_Link(0, 7, 7),
    Diplomatic_Fleet(0, 6, 0),
    Mining_Colony(5, 0, 5),
    Research_Station(5, 5, 0),
    Trade_Fleet(0, 5, 5),
    Shellworld(0, 20, 0),
    Warp_Portal(0, 8, 0),
    // From Shadow of the Rift
    // TODO: These
    Quantum_Labs(0, 7, 0),
    Ancient_Labs(8, 0, 0),
    Genetics_Labs(0, 3, 5);
    
    private final int economy;
    private final int materials;
    private final int science;
    private Development(int economy, int materials, int science) {
        this.economy = economy;
        this.materials = materials;
        this.science = science;
    }
    
    public int getEconomyCost() {
        return economy;
    }
    
    public int getMaterialsCost() {
        return materials;
    }
    
    public int getScienceCost() {
        return science;
    }
}
