package polowiec.mateusz.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CalculateService {

    public void loadAndCalculateNumbers(Scanner input) {
        List<Integer> loadedNumbers = loadNumbers(input);
        if (!loadedNumbers.isEmpty()) {
            List<Integer> firstNumberList = loadedNumbers.stream()
                    .filter(number -> number < 7 && loadedNumbers.contains(13 - number))
                    .sorted()
                    .toList();

            System.out.println("Result: ");
            firstNumberList.forEach(number -> System.out.println(number + " " + (13 - number)));
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
}
