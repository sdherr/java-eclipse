package model.ships;

import java.util.ArrayList;
import java.util.List;

import model.Die;

public enum ShipPart {
    Hull,
    Improved_Hull,
    Shard_Hull,
    Conifold_Field,
    Electron_Computer,
    Sentient_Hull,
    Positron_Computer,
    Gluon_Computer,
    Axion_Computer,
    Nuclear_Source,
    Fusion_Source,
    Tachyon_Source,
    Zero_Point_Source,
    Hypergrid_Source,
    Muon_Source,
    Nuclear_Drive,
    Fusion_Drive,
    Tachon_Drive,
    Conformal_Drive,
    Jump_Drive,
    Gauss_Shield,
    Phase_Shield,
    Flux_Shield,
    Ancient_Shield, // only found on Ancient Dreadnought
    Morph_Shield,
    Ion_Cannon,
    Ion_Disruptor,
    Ion_Turret,
    Plasma_Cannon,
    Antimatter_Cannon,
    Flux_Missile,
    Plasma_Missile,
    Antimatter_Missile, // only found on Ancient Cruiser
    Interceptor_Bay,
    None;

	public int getPower() {
		switch (this) {
		case Ion_Cannon:
			return -1;
		case Ion_Turret:
			return -1;
		case Plasma_Cannon:
			return -2;
		case Antimatter_Cannon:
			return -4;
		case Phase_Shield:
			return -1;
		case Flux_Shield:
			return -2;
		case Conifold_Field:
			return -2;
		case Positron_Computer:
			return -1;
		case Gluon_Computer:
			return -2;
		case Nuclear_Source:
			return 3;
		case Fusion_Source:
			return 6;
		case Tachyon_Source:
			return 9;
		case Zero_Point_Source:
			return 12;
		case Hypergrid_Source:
			return 11;
		case Muon_Source:
			return 2;
		case Nuclear_Drive:
			return -1;
		case Fusion_Drive:
			return -2;
		case Tachon_Drive:
			return -3;
		case Conformal_Drive:
			return -2;
		case Jump_Drive:
			return -2;
		case Interceptor_Bay:
			return -2;
		default:
			return 0;
		}
	}

	public int getInitiative() {
		switch (this) {
		case Positron_Computer:
			return 1;
		case Gluon_Computer:
			return 2;
		case Nuclear_Drive:
			return 1;
		case Fusion_Drive:
			return 2;
		case Tachon_Drive:
			return 3;
		case Conformal_Drive:
			return 2;
		case Flux_Missile:
			return 2;
		case Ion_Disruptor:
			return 3;
		case Morph_Shield:
			return 2;
		case Muon_Source:
			return 1;
		default:
			return 0;
		}
	}

	public int getHull() {
		switch (this) {
		case Hull:
			return 1;
		case Improved_Hull:
			return 2;
		case Conifold_Field:
			return 3;
		case Sentient_Hull:
			return 1;
		case Interceptor_Bay:
			return 1;
		case Shard_Hull:
			return 3;
		default:
			return 0;
		}
	}

	public List<Die> getDice() {
		List<Die> dice = new ArrayList<Die>();
		switch (this) {
		case Ion_Cannon:
			dice.add(Die.Yellow);
			break;
		case Plasma_Cannon:
			dice.add(Die.Orange);
			break;
		case Antimatter_Cannon:
			dice.add(Die.Red);
			break;
		case Ion_Turret:
			dice.add(Die.Yellow);
			dice.add(Die.Yellow);
			break;
		case Ion_Disruptor:
			dice.add(Die.Yellow);
			break;
		default: // do nothing
		}
		return dice;
	}
	
	public List<Die> getMissileDice() {
		List<Die> dice = new ArrayList<Die>();
		switch (this) {
		case Flux_Missile:
			dice.add(Die.Yellow);
			dice.add(Die.Yellow);
			break;
		case Plasma_Missile:
			dice.add(Die.Orange);
			dice.add(Die.Orange);
			break;
		case Antimatter_Missile:
		    dice.add(Die.Red);
		    break;
		default: // do nothing
		}
		return dice;
	}

	public int getComputers() {
		switch (this) {
		case Electron_Computer:
			return 1;
		case Sentient_Hull:
			return 1;
		case Positron_Computer:
			return 2;
		case Gluon_Computer:
			return 3;
		case Axion_Computer:
			return 3;
		default:
			return 0;
		}
	}

	public int getShields() {
		switch (this) {
		case Gauss_Shield:
			return 1;
		case Phase_Shield:
			return 2;
		case Flux_Shield:
			return 3;
		case Morph_Shield:
			return 1;
		default:
			return 0;
		}
	}

	public int getDrives() {
		switch (this) {
		case Nuclear_Drive:
			return 1;
		case Jump_Drive:
			return 1;
		case Fusion_Drive:
			return 2;
		case Tachon_Drive:
			return 3;
		case Conformal_Drive:
			return 4;
		default:
			return 0;
		}
	}

	public int getInterceptorBays() {
		switch (this) {
		case Interceptor_Bay:
			return 2;
		default:
			return 0;
		}
	}

	public int getRegeneration() {
		switch (this) {
		case Morph_Shield:
			return 1;
		case Ancient_Shield:
		    return 1;
		default:
			return 0;
		}
	}
}
