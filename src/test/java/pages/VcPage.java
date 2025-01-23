package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VcPage {
    final SelenideElement
            cardName = $(".subsite-card__name");

    @Step("Проверяем что имя компании МТС")
    public VcPage checkNameCompany() {
        cardName.shouldHave(text("МТС"));
        return this;
    }
}
