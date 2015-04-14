package model.ships;

public abstract class AncientShip extends Ship {
    @Override
    protected int getCost() {
        return 0;
    }

    @Override
    protected int getInherentPower() {
        return 20; // large enough so we won't have to worry about it
    }
}