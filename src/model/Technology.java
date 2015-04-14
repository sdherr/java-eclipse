package model;

public enum Technology {
    Neutron_Bombs(2, 2, TechnologyType.Military),
    Starbase(4, 3, TechnologyType.Military),
    Plasma_Cannon(6, 4, TechnologyType.Military),
    Phase_Shield(8, 5, TechnologyType.Military),
    Advanced_Mining(10, 6, TechnologyType.Military),
    Tachyon_Source(12, 6, TechnologyType.Military),
    Plasma_Missile(14, 7, TechnologyType.Military),
    Gluon_Computer(16, 8, TechnologyType.Military),
    Gauss_Shield(2, 2, TechnologyType.Grid),
    Improved_Hull(4, 3, TechnologyType.Grid),
    Fusion_Source(6, 4, TechnologyType.Grid),
    Positron_Computer(8, 5, TechnologyType.Grid),
    Advanced_Economy(10, 6, TechnologyType.Grid),
    Tachyon_Drive(12, 6, TechnologyType.Grid),
    Antimatter_Cannon(14, 7, TechnologyType.Grid),
    Quantum_Grid(16, 8, TechnologyType.Grid),
    Nanorobots(2, 2, TechnologyType.Nano),
    Fusion_Drive(4, 3, TechnologyType.Nano),
    Advanced_Robotics(6, 4, TechnologyType.Nano),
    Orbital(8, 5, TechnologyType.Nano),
    Advanced_Labs(10, 6, TechnologyType.Nano),
    Monolith(12, 6, TechnologyType.Nano),
    Artifact_Key(14, 7, TechnologyType.Nano),
    Wormhole_Generator(16, 8, TechnologyType.Nano),
    Antimatter_Splitter(5, 5, TechnologyType.Rare),
    Neutron_Absorber(5, 5, TechnologyType.Rare),
    Distortion_Shield(7, 6, TechnologyType.Rare),
    Cloaking_Device(7, 6, TechnologyType.Rare),
    Point_Defence(11, 8, TechnologyType.Rare),
    Conifold_Field(5, 5, TechnologyType.Rare),
    Sentient_Hull(5, 5, TechnologyType.Rare),
    Interceptor_Bay(9, 7, TechnologyType.Rare),
    Flux_Missile(11, 8, TechnologyType.Rare),
    Zero_Point_Source(15, 10, TechnologyType.Rare);
    
    private final int defaultCost;
    private final int minimumCost;
    private final TechnologyType type;
    private Technology(int defaultCost, int minimumCost, TechnologyType type) {
        this.defaultCost = defaultCost;
        this.minimumCost = minimumCost;
        this.type = type;
    }
    
    public TechnologyType getType() {
        return type;
    }
    
    public int getMinimumCost() {
        return minimumCost;
    }
    
    public int getDefaultCost() {
        return defaultCost;
    }
}
