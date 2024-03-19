package task2;

import java.util.Random;

public class RandomInheritance extends Random {
    public int generateEvenNumber(int bound) {
        int evenNumber;
        do {
            evenNumber = nextInt(bound);
        } while (evenNumber % 2 != 0);
        return evenNumber;
    }
}

