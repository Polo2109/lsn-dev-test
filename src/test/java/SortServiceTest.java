import org.junit.jupiter.api.Test;
import polowiec.mateusz.service.SortService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortServiceTest {

    @Test
    void shouldLoadAndSortNumbers() {
        ByteArrayInputStream userInput = new ByteArrayInputStream("1 10 20 20 2 5".getBytes());
        System.setIn(userInput);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        SortService sortService = new SortService();
        Scanner input = new Scanner(System.in);
        sortService.loadAndSortNumbers(input);

        String[] lines = baos.toString().split(System.lineSeparator());

        assertEquals("1 2 5 10 20 ", lines[lines.length-5]);
        assertEquals("count: 6", lines[lines.length-4]);
        assertEquals("distinct: 5", lines[lines.length-3]);
        assertEquals("min: 1", lines[lines.length-2]);
        assertEquals("max: 20", lines[lines.length-1]);
    }

}