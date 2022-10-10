package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CsvSourceParameterizedTest {

    @CsvSource({
            "Git Pocket Guide, Richard E. Silverman",
            "Learning JavaScript Design Patterns, Addy Osmani"
    })

    @ParameterizedTest(name = "Check info on Books page: {0}")
    void checkNameAndAuthorOnBookPageTest(String bookName, String authorName) {
        open("https://demoqa.com/books");
        $(byText(bookName)).click();
        $("#title-wrapper").shouldHave(text(bookName));
        $("#author-wrapper").shouldHave(text(authorName));
    }
}
