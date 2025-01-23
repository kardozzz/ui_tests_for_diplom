package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    final SelenideElement tgLogo = $(".tgme_head_brand"),
            channelName = $(".tgme_page_title");

    @Step("Проверить название канала")
    public TelegramPage checkTgChannelName() {
        channelName.shouldHave(Condition.text("Это МТС"));
        return this;
    }

    @Step("Проверить наличие кликабельного Telegram лого")
    public void checkTgLogo() {
        tgLogo.should(visible);
    }
}
