package FileReader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader fileReader = new FileReader();

    @Test
    void read() {
        String input = "src/Utilities/document.txt";
        List<String> result = fileReader.read(input);
        List<String> expected = List.of(
                "line 1;part 1-2",
                "line 2;part 2-2",
                "line 3;part 3-2"
        );

        assertEquals(expected, result);


    }
}