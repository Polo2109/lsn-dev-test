package polowiec.mateusz.enums;

import java.util.NoSuchElementException;

public enum ActionEnum {

    EXIT(0, "Exit: "),
    SORT(1, "Sort numbers: "),
    CALCULATE(2, "Calculate numbers: "),
    GRAPH(3, "Count graphs: ");

    private final int number;
    private final String description;

    ActionEnum(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static ActionEnum findByNumber(int number) {
        for (ActionEnum value : ActionEnum.values()) {
            if (value.getNumber() == number)
                return value;
        }
        throw new NoSuchElementException("Option not recognized");
    }
}
