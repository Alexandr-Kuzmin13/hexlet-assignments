package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(path.toUri()), car);
    }

    public static Car extract(Path path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(Files.readString(path), Car.class);

    }
}
// END
