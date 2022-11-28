package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {

    private CharSequence text;

    @BeforeEach
    public void beforeEach() {

        text = new ReversedSequence("abcdef");
    }

    @Test
    void testToString() {

        var expected = "fedcba";
        var actual = text.toString();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCharAt() {

        var expected = 'e';
        var actual = text.toString().charAt(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testLength() {

        var expected = 6;
        var actual = text.toString().length();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSubSequence() {

        var expected = "edc";
        var actual = text.toString().subSequence(1, 4);

        assertThat(actual).isEqualTo(expected);
    }
}


