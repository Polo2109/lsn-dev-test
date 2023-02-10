package polowiec.mateusz.service;

import java.util.*;

public class GraphService {
    
    public void countSeparatedGraphs(Scanner input) {
        Set<Integer> connectedNumbers = new HashSet<>();
        int result = 0;

        Set<String> loadedNumbers = loadNumbers(input);

        if (!loadedNumbers.isEmpty()) {
            for (String loadedNumber : loadedNumbers) {
                List<Integer> integers = Arrays.stream(loadedNumber.split(" ")).map(Integer::parseInt).toList();
                if (!connectedNumbers.contains(integers.get(0)) && !connectedNumbers.contains(integers.get(1)))
                    result++;
                else if (connectedNumbers.contains(integers.get(0)) && connectedNumbers.contains(integers.get(1)))
                    result--;
                connectedNumbers.addAll(integers);
            }
            System.out.println("AmountOfGraph: " + result);
        }
    }

    private Set<String> loadNumbers(Scanner input) {
        try {
            Set<String> inputNumbersList = new HashSet<>();
            System.out.println("How many pairs?");
            int inputNumbers = input.nextInt();
            input.nextLine();
            System.out.println("Write " + inputNumbers + " pairs");
            for (int i = 0; i < inputNumbers; i++) {
                String numbers = input.nextLine();
                if (!numbers.matches("\\d+\\s\\d+")) {
                    throw new NumberFormatException();
                } else
                    inputNumbersList.add(numbers);
            }
            return inputNumbersList;
        } catch (NumberFormatException e) {
            System.err.println("You have to write only numbers, which are separate only with one white space");
        }
        return Collections.emptySet();
    }
}
