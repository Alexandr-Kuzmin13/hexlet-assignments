package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static final Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSet() throws Exception {

        var contentMap = Utils.unserialize(Utils.readFile("src/test/resources/file"));

        KeyValueStorage storage = new FileKV("src/test/resources/file", contentMap);

        storage.set("key", "10");

        var actual = storage.get("key", "default");

        var expected = "10";

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGet() throws Exception {

        var contentMap = Utils.unserialize(Utils.readFile("src/test/resources/file"));

        KeyValueStorage storage = new FileKV("src/test/resources/file", contentMap);

        storage.set("key", "10");

        var actual = storage.get("key", "default");

        var expected = "10";

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testUnSet() throws Exception {

        var contentMap = Utils.unserialize(Utils.readFile("src/test/resources/file"));

        KeyValueStorage storage = new FileKV("src/test/resources/file", contentMap);

        storage.unset("key");

        var actual = storage.get("key", "default");

        var expected = "default";

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testToMap() throws Exception {

        var contentMap = Utils.unserialize(Utils.readFile("src/test/resources/file"));

        KeyValueStorage storage = new FileKV("src/test/resources/file", contentMap);

        storage.unset("key");

        var actual = storage.toMap();

        assertThat(actual).isEqualTo(contentMap);
    }
    // END
}
