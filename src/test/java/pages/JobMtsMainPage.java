package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class JobMtsMainPage {
    final SelenideElement buttonVacancy = $(".h-button__text"),
            linkWorkInIt = $$(".header__menu-item").findBy(Condition.text("Работа в IT")),
            linkAllVacancies = $$(".header__menu-item").findBy(Condition.text("Все вакансии")),
            clickAllVacancies = $$(".header__menu-item").findBy(Condition.text("Все вакансии")),
            linkProgram = $$(".header__menu-item").findBy(Condition.text("Стажировки")),
            buttonSearch = $$(".h-button").find(Condition.text("Найти")),
            selectHabrLink = $$(".swiper-wrapper").find(Condition.text("Пишем статьи о разработке")),
            scrollToSearchResult = $(".social-slider__item-text");

    @Step("Открываем главную страницу")
    public JobMtsMainPage pageOpen() {
        open("/");
        return this;
    }

    @Step("Проверяем кликабельность кнопки Работа в IT")
    public JobMtsMainPage checkButtonWorkInIt() {
        linkWorkInIt.shouldBe(clickable);
        return this;
    }

    @Step("Проверяем кликабельность кнопки Стажировки")
    public JobMtsMainPage checkButtonProgram() {
        linkProgram.shouldBe(clickable);
        return this;
    }

    @Step("Проверяем кликабельность кнопки Все вакансии")
    public JobMtsMainPage checkButtonAllVacancy() {
        linkAllVacancies.shouldBe(clickable);
        return this;
    }

    @Step("Нажимаем на кнопку Все вакансии")
    public JobMtsMainPage clickButtonAllVacancy() {
        clickAllVacancies.click();
        return this;
    }

    @Step("Проверяем кликабельность кнопки Найти")
    public JobMtsMainPage checkButtonSearch() {
        buttonSearch.shouldBe(clickable);
        return this;
    }

    @Step("Проверяем кликабельность ссылка на Habr")
    public JobMtsMainPage checkSelectHabr() {
        selectHabrLink.shouldBe(clickable);
        return this;
    }

    @Step("Скролл страницы до карусели социальных сетей")
    public JobMtsMainPage scrollToResultSearch() {
        scrollToSearchResult.scrollTo();
        return this;
    }


}
