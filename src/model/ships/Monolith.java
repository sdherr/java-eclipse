package model.ships;

import model.Player;
import model.PlayerSpecies;
import model.Technology;

/*
 * Monoliths are not ships in any respect, but they can chill here with everything
 * else that is buildable.
 */
public class Monolith {
    /*
     * I really wanted to have in Purchasable interface that specified static
     * canBePurchased(Player) and getCost(Player), but java < 8 doesn't support
     * static methods in interfaces. Instead Purchasable classes will just
     * magically have these methods, and something else will "know" that they
     * are the only purchasable things.
     */
    public static boolean canBePurchased(Player player) {
        return player.hasResearched(Technology.Monolith);
    }

    public static int getCost(Player player) {
        if (player.getSpecies() == PlayerSpecies.Mechanema) {
            return 8;
        }
        return 10;
    }
}
