package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MethodSourceParameterizedTest {

    static Stream<Arguments> bookNameAndDescription() {

        return Stream.of(
                Arguments.of("Git Pocket Guide", List.of(
                        "9781449325862",
                        "Git Pocket Guide",
                        "A Working Introduction",
                        "Richard E. Silverman",
                        "O'Reilly Media",
                        "234",
                        "This pocket guide is the perfect on-the-job companion to Git, the distributed version " +
                                "control system. It provides a compact, readable introduction to Git for new users, " +
                                "as well as a reference to common commands and procedures for those of you with Git exp",
                        "http://chimera.labs.oreilly.com/books/1230000000561/index.html"
                )),

                Arguments.of("Learning JavaScript Design Patterns", List.of(
                        "9781449331818",
                        "Learning JavaScript Design Patterns",
                        "A JavaScript and jQuery Developer's Guide",
                        "Addy Osmani",
                        "O'Reilly Media",
                        "254",
                        "With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, " +
                                "and maintainable JavaScript by applying classical and modern design patterns to the " +
                                "language. If you want to keep your code efficient, more manageable, and up-to-da",
                        "http://www.addyosmani.com/resources/essentialjsdesignpatterns/book/"
                ))
        );
    }

    @MethodSource("bookNameAndDescription")
    @ParameterizedTest
    void checkInfoOnBookPageTest(String bookName, List<String > bookInfo) {

        open("https://demoqa.com/books");
        $$(".rt-tr-group .action-buttons").find(text(bookName)).click();
        $$(".profile-wrapper .col-md-9").shouldHave(CollectionCondition.texts(bookInfo));
    }
}
