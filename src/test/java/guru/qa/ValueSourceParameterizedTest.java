package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValueSourceParameterizedTest {

    @ValueSource(strings = {"Git Pocket Guide", "Learning JavaScript Design Patterns"})

    @ParameterizedTest(name = "Check title on Books page: {0}")
    void checkTitleOnBookPageTest(String bookName) {
        open("https://demoqa.com/books");
        $(byText(bookName)).click();
        $("#title-wrapper").shouldHave(text(bookName));
    }
}
