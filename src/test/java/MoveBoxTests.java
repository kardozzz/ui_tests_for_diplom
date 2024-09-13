import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.*;
import static com.codeborne.selenide.Selenide.*;

public class MoveBoxTests {
    @BeforeAll
    static void beforceAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropTests() {
        open("/drag_and_drop");
        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        System.out.println("Квадраты поменялись местами.");
        $("#column-b").dragAndDrop(to("#column-a"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        System.out.println("Квадраты поменялись обратно.");
    }
}
