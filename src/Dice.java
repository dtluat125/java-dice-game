import java.util.Random;

public class Dice {
    private int biasSide = -1;

    public Dice(int biasSide) {
        this.biasSide = biasSide;
    }

    public int rollTheDice() {
        int min = 0;
        int max = 99;

        // Generate random int value from 50 to 100
        int randomInt = (int) Math.round(Math.random() * (max - min + 1) + min);
        int minBiased = 16 * (biasSide - 1);
        int maxBiased = minBiased + 20;
        if (randomInt >= minBiased && randomInt <= maxBiased)
            return biasSide;
        if (randomInt < minBiased) {
            return randomInt / 16 + 1;
        }
        return biasSide + 1 + (randomInt - maxBiased) / 16;
    }
}
