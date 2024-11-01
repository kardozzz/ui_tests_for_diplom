package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class JobMtsMainPage {
    final SelenideElement buttonVacancy = $(".h-button__text"),
            linkWorkInIt = $$(".header__menu-item").findBy(Condition.text("Работа в IT")),
            linkAllVacancies = $$(".header__menu-item").findBy(Condition.text("Все вакансии")),
            linkProgram = $$(".header__menu-item").findBy(Condition.text("Стажировки")),
            buttonSearch = $$(".h-button").find(Condition.text("Найти")),
            selectHabrLink = $$(".swiper-wrapper").find(Condition.text("Пишем статьи о разработке")),
            scrollToSearchResult = $(".social-slider__item-text");
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

    public JobMtsMainPage checkSelectHabr() {
        selectHabrLink.shouldBe(clickable);
        return this;
    }

    public JobMtsMainPage scrollToResultSearch() {
        scrollToSearchResult.scrollTo();
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
