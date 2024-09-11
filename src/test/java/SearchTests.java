import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    static {
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("#L2AGLb").shouldHave(text("Принять все")).click();
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
