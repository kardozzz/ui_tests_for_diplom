import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void beforceAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTests() {

        String firstName = "John";
        String lastName = "Krutoy";
        String userEmail = "krutoy@gmail.com";
        String userNumber = "8911222333";
        String address = "123 Main St, Springfield";
        String state = "NCR";
        String city = "Delhi";


        // Заполняем форму.
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // deleted banner
        executeJavaScript("$('footer').remove()"); // deleted footer
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").find(".custom-control-label").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();  // Открыть календарь
        $(".react-datepicker__year-select").$("option[value='1991']").click();
        $(".react-datepicker__month-select").$("option[value='6']").click(); // Июль - это 6
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#currentAddress").setValue(address);
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText(city)).click();
        $("#submit").click();

        // Проверяем что все заполнилось верно на всплывающем окне.
        $(".modal-content").shouldHave(Condition.text(firstName));
        $(".modal-content").shouldHave(Condition.text(lastName));
        $(".modal-content").shouldHave(Condition.text(userEmail));
        $(".modal-content").shouldHave(Condition.text(userNumber));
        $(".modal-content").shouldHave(Condition.text("July"));
        $(".modal-content").shouldHave(Condition.text("1991"));
        $(".modal-content").shouldHave(Condition.text("3"));
        $(".modal-content").shouldHave(Condition.text(address));
        $(".modal-content").shouldHave(Condition.text(state));
        $(".modal-content").shouldHave(Condition.text(city));
        $(".modal-content").shouldHave(Condition.text("Sports"));
        $(".modal-content").shouldHave(Condition.text("Maths"));
        $("#closeLargeModal").click();

        // Отбивка что всё ок.
        System.out.println("Форма успешно заполнена, значения соответствуют введеным, окно закрыто.");
    }


}
