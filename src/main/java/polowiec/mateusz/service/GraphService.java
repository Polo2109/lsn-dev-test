package polowiec.mateusz.service;

import java.util.*;

public class GraphService {
    
    public void countSeparatedGraphs(Scanner input) {
        Map<Integer, Integer> connectionsMap = new HashMap<>();
        int result = 0;

        List<String> loadedNumbers = loadNumbers(input);

        loadedNumbers.forEach(numbers -> {
            String[] separatedNumbers = numbers.split(" ");
            connectionsMap.put(Integer.parseInt(separatedNumbers[0]), Integer.parseInt(separatedNumbers[1]));
        });

        for (Map.Entry<Integer, Integer> entry : connectionsMap.entrySet()) {
            if (connectionsMap.get(entry.getValue()) == null)
                result++;
        }
        System.out.println("AmountOfGraph: " + result);

    }

    private List<String> loadNumbers(Scanner input) {
        try {
            List<String> inputNumbersList = new ArrayList<>();
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
        return Collections.emptyList();
    }
}
