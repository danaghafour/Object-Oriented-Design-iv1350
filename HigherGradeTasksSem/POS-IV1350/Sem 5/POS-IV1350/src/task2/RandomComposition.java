package task2;

import java.util.Random;

public class RandomComposition {
    private Random random;

    public RandomComposition() {
        random = new Random();
    }

    public int generateOddNumber(int bound) {
        int oddNumber;
        do {
            oddNumber = random.nextInt(bound);
        } while (oddNumber % 2 == 0);
        return oddNumber;
    }
}
