package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindVacancyMtsPage {
    final SelenideElement
            inputVacancyName = $(".h-input__inner");

    // Изменяем выбор вакансии
    @Step("Выбираем вакансию по направлению")
    public FindVacancyMtsPage clickFindVacancy(String vacancyName) {
        // Находим все элементы с классом "vacancy-card__label-item-inner" и фильтруем по тексту
        SelenideElement selectVacancy = $$((".vacancy-card__label-item-inner"))
                .filterBy(Condition.text(vacancyName)) // фильтрация по тексту
                .first(); // выбираем первый из найденных элементов с нужным текстом

        selectVacancy.shouldBe(Condition.visible).click(); // кликаем по элементу
        return this;
    }

    @Step("Вводим направление вакансии")
    public FindVacancyMtsPage inputVacancy(String vacancyName) {
        inputVacancyName.setValue(vacancyName);
        return this;
    }
}
