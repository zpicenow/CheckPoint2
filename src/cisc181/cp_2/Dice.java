package cisc181.cp_2;

import java.util.Random;

/**
 * a class Dice server for game
 */
public class Dice {
    /**
     * a public static method to imitate throw the dice
     * @return 1~6 that player go
     */
    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;

    }
}
