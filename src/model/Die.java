package model;

public enum Die {
	Yellow, Orange, Red;

	public int getDamage() {
		switch (this) {
		case Yellow:
			return 1;
		case Orange:
			return 2;
		default: // case Red:
			return 4;
		}
	}
}
