package task2;

public class Main {
        public static void main(String[] args) {
            RandomInheritance randomInheritance = new RandomInheritance();
            int evenNumber = randomInheritance.generateEvenNumber(100);
            System.out.println("Random even number (Inheritance): " + evenNumber);

            RandomComposition randomComposition = new RandomComposition();
            int oddNumber = randomComposition.generateOddNumber(100);
            System.out.println("Random odd number (Composition): " + oddNumber);
        }
    }
