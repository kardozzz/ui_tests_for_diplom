package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JobMtsMainPage {
    final SelenideElement buttonVacancy = $(".h-button__text"),
            linkWorkInIt = $("[.header__menu-item-inner] [a href=/vacancies/moscow/rabota-v-it]"),
            linkAllVacancies = $(".header__menu-item-inner").shouldHave(Condition.text("Все вакансии")),
            linkProgram = $("[.header__menu-item-inner] [a href=/programs]"),
            buttonSearch = $("[.h-button] [href=/vacancies");
//            scrollToSearchResult = $(".h-button.h-button--lg"),
//            useSwiper = $(".social-slider__item-title"),
//            checkSelectVacancy = $(".row title-row");


    public JobMtsMainPage pageOpen() {
        open("/");
        return this;
    }

    public JobMtsMainPage checkButtonVacancy() {
        buttonVacancy.shouldBe(clickable);
        return this;
    }

    public JobMtsMainPage checkButtonWorkInIt() {
        linkWorkInIt.shouldBe(clickable);
        return this;
    }

    public JobMtsMainPage checkButtonProgram() {
        linkProgram.shouldBe(clickable);
        return this;
    }

    public JobMtsMainPage checkButtonAllVacancy() {
        linkAllVacancies.shouldBe(clickable);
        return this;
    }

    public JobMtsMainPage checkButtonSearch() {
        buttonSearch.shouldBe(clickable);
        return this;
    }

//    public clickHabrSwiper(){
//        useSwiper.shouldHave(text("Хабр")).click();
//        return this;
//    }
//    public clickTgSwiper(){
//        useSwiper.shouldHave(text("Это МТС")).click();
//        return this;
//    }
//    public clickVcSwiper(){
//        useSwiper.shouldHave(text("VC")).click();
//        return this;
//    }
}
