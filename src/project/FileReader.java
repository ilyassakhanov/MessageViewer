package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FileReader {
    String read(String directory) throws Exception {
        Path filePath = Paths.get(directory);

        try {
            String content = Files.readString(filePath);

            return content;
        } catch(Exception e) {
            throw new Exception();
        }
    }
}
