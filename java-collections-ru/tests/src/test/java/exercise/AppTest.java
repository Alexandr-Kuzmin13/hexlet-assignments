package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var actual1 = App.take(numbers1, 2);
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        var actual2 = App.take(numbers2, 8);
        List<Integer> expected2 = new ArrayList<>();
        expected2.add(7);
        expected2.add(3);
        expected2.add(10);
        assertThat(actual2).isEqualTo(expected2);
        // END
    }
}
