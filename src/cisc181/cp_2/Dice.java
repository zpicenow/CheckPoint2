package cisc181.cp_2;

import java.util.Random;

/**
 * a class Dice server for game
 */
public class Dice {

    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;

    }
}
