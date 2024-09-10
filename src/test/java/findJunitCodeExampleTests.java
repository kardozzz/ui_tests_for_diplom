import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class findJunitCodeExampleTests {

    @BeforeAll
    static void beforceAll() {
        Configuration.browserSize = "800x600";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void findSoftAssertionsPage() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(Condition.text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
        System.out.println("Внутри есть пример кода для JUnit5.");

    }
}
