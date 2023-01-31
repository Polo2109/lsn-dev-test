package polowiec.mateusz.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortService {

    public void loadAndSortNumbers(Scanner input) {
        List<Integer> unsortedNumbers = loadNumbers(input);
        if (!unsortedNumbers.isEmpty()) {
            List<Integer> sortedNumbers = unsortedNumbers.stream()
                    .distinct()
                    .sorted()
                    .toList();
            printResult(sortedNumbers, unsortedNumbers.size());
        }
    }

    private List<Integer> loadNumbers(Scanner input) {
        try {
            System.out.println("Enter the numbers separated by white space");
            return Arrays.stream(input.nextLine()
                            .split(" "))
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            System.err.println("You have to write only numbers, which are separate only with one white space");
        }
        return Collections.emptyList();
    }

    private void printResult(List<Integer> sortedNumbers, int distinct) {
        System.out.println("Result: ");
        System.out.println(sortedNumbers.stream()
                .map(Object::toString)
                .reduce("", (integer, integer2) -> integer + integer2 + " "));
        System.out.println("count: " + distinct);
        System.out.println("distinct: " + sortedNumbers.size());
        System.out.println("min: " + sortedNumbers.get(0));
        System.out.println("max: " + sortedNumbers.get(sortedNumbers.size() - 1));
        System.out.println();
    }
}
