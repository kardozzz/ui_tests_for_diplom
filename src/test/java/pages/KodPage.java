package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class KodPage {
    final SelenideElement
            authorName = $(".AuthorTitle_titleWrapper__baALq"),
            authorAbout = $(".AuthorTitle_info__basqy");

    @Step("Проверяем что имя автора МТС")
    public KodPage checkAuthorName() {
        authorName.shouldHave(text("МТС"));
        return this;
    }

    @Step("Проверяем что информация об авторе заполнена нужным текстом")
    public KodPage checkAuthorDescription() {
        authorAbout.shouldHave(text("МТС — экосистема цифровых сервисов в сферах мобильной связи, развлечений, Big Data, AI, Cloud, FinTech."));
        return this;
    }
}
