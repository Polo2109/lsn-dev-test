package polowiec.mateusz.service;

import polowiec.mateusz.model.VerticesPair;

import java.util.*;

public class GraphService {
    
    public void countSeparatedGraphs(Scanner input) {
        List<String> loadedNumbers = loadNumbers(input);

        List<VerticesPair> pairsOfVertices = new ArrayList<>();

        for (String loadedNumber : loadedNumbers) {
            List<Integer> pairOfNumbers = Arrays.stream(loadedNumber.split(" "))
                    .map(Integer::valueOf)
                    .toList();

            pairsOfVertices.add(new VerticesPair(pairOfNumbers.get(0), pairOfNumbers.get(1)));
        }
        List<Integer> allSecondNumbers = pairsOfVertices.stream()
                .map(VerticesPair::getSecondNumber)
                .toList();

        int amountOfGraph = 0;
        for (VerticesPair verticesPair : pairsOfVertices) {
            if (!allSecondNumbers.contains(verticesPair.getFirstNumber()))
                amountOfGraph++;
        }
        System.out.println("AmountOfGraph: " + amountOfGraph);

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
