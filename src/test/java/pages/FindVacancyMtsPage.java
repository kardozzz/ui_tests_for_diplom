package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindVacancyMtsPage {
    final SelenideElement
            inputVacancyName = $(".h-input__inner"),
            selectVacancy = $$(".vacancy-card__label-item-inner").findBy(Condition.text("Тестирование"));
    @Step("Вводим направление вакансии")
    public  FindVacancyMtsPage inputVacancy() {
        inputVacancyName.setValue("Тестирование");
        return this;
    }
    @Step("Выбираем первую найденную вакансию по направлению")
    public FindVacancyMtsPage clickFindVacancy() {
        selectVacancy.shouldHave(Condition.text("Тестирование")).click();
        return this;
    }
}
