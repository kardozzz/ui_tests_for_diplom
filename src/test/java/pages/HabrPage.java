package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HabrPage {
    final SelenideElement
            logoHabr = $(".tm-header__container"),
            profileName = $(".tm-company-card__info");

    @Step("Проверяем что на открывшейся странице в лого текст Habr")
    public HabrPage checkLogoHabr() {
        logoHabr.shouldHave(text("Хабр"));
        return this;
    }

    @Step("Проверяем название компании МТС")
    public HabrPage checkProfileName() {
        profileName.shouldHave(text("МТС"));
        return this;
    }
}
