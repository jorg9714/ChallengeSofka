package utils;

import java.util.Random;

public class RandomVariables {
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt(max-1 - min+1)+ min;
    }
}
