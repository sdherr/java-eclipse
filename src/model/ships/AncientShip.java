package model.ships;

public abstract class AncientShip extends ShipBlueprint {
    @Override
    protected int getInherentPower() {
        return 20; // large enough so we won't have to worry about it
    }

    @Override
    public int getCost() {
        return 0;
    }
}
