package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled("Disables all tests in class")
public class JUnitAssertions {

    @Disabled("Disables one test in class")
    @Test
    void firstJUnitTest() {
        Assertions.assertTrue(2 + 2 != 5);
    }

    @DisplayName("Here is name of the test")
    @Test
    void secondJUnitTest() {
        Assertions.assertEquals("True", "True");
    }
}
