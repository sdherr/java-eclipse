package model;

public class Distortion {
    private final int turns;
    private final DistortionType type;
    
    Distortion(DistortionType type, int turns) {
        this.turns = turns;
        this.type = type;
    }
    
    public DistortionType getType() {
        return type;
    }
    
    public int getTurns() {
        return turns;
    }
}
