package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.*;

public class JobMtsMainPage {
    final SelenideElement
            clickAllVacancies = $$(".header__menu-item").findBy(Condition.text("Все вакансии")),
            habrSlider = $$(".social-slider__item").findBy(Condition.text("Хабр")),
            vcSlider = $$(".social-slider__item").findBy(Condition.text("VC")),
            kodSlider = $$(".social-slider__item").findBy(Condition.text("Код Дурова")),
            scrollToSearchResult = $(".social-slider__item-text"),
            telegramSlider = $$(".social-slider__item").findBy(Condition.text("Это МТС"));

    @Step("Открываем главную страницу")
    public JobMtsMainPage pageOpen() {
        open("/");
        return this;
    }


    @Step("Нажимаем на кнопку Все вакансии")
    public JobMtsMainPage clickButtonAllVacancy() {
        clickAllVacancies.click();
        return this;
    }


    @Step("Проверяем переход из карусели соц.сетей на профиль Habr")
    public JobMtsMainPage clickOnHabrSlider() {
        habrSlider.shouldHave(href("https://habr.com/ru/companies/ru_mts"));
        habrSlider.click();
        return this;
    }

    @Step("Проверяем переход из карусели соц.сетей на профиль Vc.ru")
    public JobMtsMainPage clickOnVcSlider() {
        vcSlider.shouldHave(href("https://vc.ru/mts"));
        vcSlider.click();
        return this;
    }


    @Step("Проверяем переход из карусели соц.сетей на профиль Kod.ru")
    public JobMtsMainPage clickOnKodSlider() {
        kodSlider.shouldHave(href("https://kod.ru/author/mts"));
        kodSlider.click();
        return this;
    }

    @Step("Скролл страницы до карусели социальных сетей")
    public JobMtsMainPage scrollToResultSearch() {
        scrollToSearchResult.scrollTo();
        return this;
    }

    @Step("Проверяем переход из карусели соц.сетей в Telegram канал")
    public JobMtsMainPage clickOnTgSlider() {
        telegramSlider.shouldHave(href("https://t.me/it_is_mts"));
        telegramSlider.click();
        return this;
    }
}
