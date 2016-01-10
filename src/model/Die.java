package model;

public enum Die {
	Yellow, Orange, Blue, Red, Pink, Grey;

	public int getDamage() {
		switch (this) {
		case Yellow:
			return 1;
		case Orange:
			return 2;
		case Blue:
		    return 3;
		default: // case Red:
			return 4;
		}
		// TODO: add pink and grey
	}
}
