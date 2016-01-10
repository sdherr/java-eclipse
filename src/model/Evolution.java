package model;

public enum Evolution {
    Extra_Build(2),
    Extra_Upgrade(3),
    Extra_Reputation_Ambassidor_Slot(3),
    Extra_Reputation_Draw(2),
    Extra_Research(5),
    Extra_Evolution(3),
    Extra_Colony_Ship(2),
    Extra_Move(3),
    Cheap_Interceptor(3),
    Cheap_Cruiser(3),
    Cheap_Dreadnought(3),
    Cheap_Orbital(3),
    Cheap_Monolith(3),
    Additional_Pink(5),
    Additional_Brown(5),
    Additional_Orange(5),
    Trading_Pink(2),
    Trading_Brown(2),
    Trading_Orange(2),
    VP_Evolution(8),
    VP_Orbital(3),
    VP_Monolith(4),
    VP_Sectors(3),
    VP_Reputation(3),
    VP_Galactic_Center(4),
    VP_Artifact(6);

    private final int cost;
    Evolution(int cost) {
        this.cost = cost;
    }
}
