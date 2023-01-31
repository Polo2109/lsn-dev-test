import org.junit.jupiter.api.Test;
import polowiec.mateusz.service.CalculateService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    @Test
    void shouldLoadAndCalculateNumbers() {
        ByteArrayInputStream userInput = new ByteArrayInputStream("1 2 10 7 5 3 6 6 13 0".getBytes());
        System.setIn(userInput);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        CalculateService calculateService = new CalculateService();
        Scanner input = new Scanner(System.in);
        calculateService.loadAndCalculateNumbers(input);

        String[] lines = baos.toString().split(System.lineSeparator());

        assertEquals("0 13", lines[lines.length-4]);
        assertEquals("3 10", lines[lines.length-3]);
        assertEquals("6 7", lines[lines.length-2]);
        assertEquals("6 7", lines[lines.length-1]);
    }
}