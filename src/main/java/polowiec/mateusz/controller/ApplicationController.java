package polowiec.mateusz.controller;

import polowiec.mateusz.enums.ActionEnum;
import polowiec.mateusz.service.CalculateService;
import polowiec.mateusz.service.GraphService;
import polowiec.mateusz.service.SortService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ApplicationController {

    public void runApp() {
        SortService sortService = new SortService();
        CalculateService calculateService = new CalculateService();
        GraphService graphService = new GraphService();
        try (Scanner input = new Scanner(System.in)) {
            ActionEnum action;
            do {
                printOptions();
                action = getAction(input);
                switch (action) {
                    case SORT -> sortService.loadAndSortNumbers(input);
                    case CALCULATE -> calculateService.loadAndCalculateNumbers(input);
                    case GRAPH -> graphService.countSeparatedGraphs(input);
                    case EXIT -> System.out.println("Bye");
                    default -> System.out.println("Option not recognized");
                }
                System.out.println();
            } while (!ActionEnum.EXIT.equals(action));
        }
    }

    private void printOptions() {
        System.out.println("Choose one of options:");
        for (ActionEnum value : ActionEnum.values()) {
            System.out.println(value.getDescription() + value.getNumber());
        }
    }

    private ActionEnum getAction(Scanner input) {
        boolean actionOk = false;
        ActionEnum action = null;

        while (!actionOk) {
            try {
                action = ActionEnum.findByNumber(Integer.parseInt(input.nextLine()));
                actionOk = true;
            } catch (NumberFormatException e) {
                System.err.println("Value is not a number, try again");
            } catch (NoSuchElementException e) {
                System.err.println(e.getMessage());
            }
        }
        return action;
    }
}
