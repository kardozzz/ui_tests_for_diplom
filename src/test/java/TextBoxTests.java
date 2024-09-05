import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.ScrollIntoView;
import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

    @BeforeAll
    static void Beforceall() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillFormTests(){
        open("/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Krutoy");
        $("#userEmail").setValue("krutoy@gmail.com");
        $((".custom-radio:nth-child(1) > .custom-control-label")).click();
        $("#userNumber").setValue("8911222333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--001:nth-child(1)").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".option[value='1987']").scrollTo();





    }

}
