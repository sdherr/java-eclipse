package model;

public class ReputationTile {
    private ReputationTileType type;
    private Integer value;
    
    ReputationTile(ReputationTileType type, Integer value) {
        this.type = type;
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public ReputationTileType getType() {
        return type;
    }
}
