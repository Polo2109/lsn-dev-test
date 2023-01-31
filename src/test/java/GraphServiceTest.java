import org.junit.jupiter.api.Test;
import polowiec.mateusz.service.GraphService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphServiceTest {

    @Test
    void shouldCountSeparatedGraphs() {
        String userInput = String.format("3%s2 3%s1 2%s5 6",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        GraphService graphService = new GraphService();
        Scanner input = new Scanner(System.in);
        graphService.countSeparatedGraphs(input);

        String[] lines = baos.toString().split(System.lineSeparator());

        assertEquals("AmountOfGraph: 2", lines[lines.length-1]);
    }
}