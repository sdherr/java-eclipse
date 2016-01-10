package model;

public enum DistortionType {
    To_Ship(1),
    To_Ships(1),
    To_Starbase(2),
    To_Explore(1),
    From_Action(2),
    From_Orbital(2),
    From_Starbase(1),
    From_Cruiser(2),
    From_Dreadnought(3),
    From_Five_Six_Pink(2),
    From_Five_Seven_Pink(2),
    From_Five_Eight_Brown(2),
    From_Five_Eight_Orange(2),
    From_Plasma_Missile(2),
    From_Gluon_Computer(2),
    From_Positron_Computer(1),
    From_Tachyon_Drive(1),
    From_Tachyon_Source(1);
    
    private final int penalty;
    DistortionType(int penalty) {
        this.penalty = penalty;
    }
    
    public int getPenalty() {
        return penalty;
    }
}
