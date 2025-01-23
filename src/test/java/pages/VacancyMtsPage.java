package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacancyMtsPage {
    final SelenideElement buttonRespond = $x("//button/span[2]"),
            inputFirstName = $(".mts-form-field:nth-child(1) .mts-input__field"),
            inputLastName = $(".mts-form-field:nth-child(2) .mts-input__field"),
            inputPhone = $(".mts-form-field:nth-child(3) .mts-input__field"),
            inputEmail = $(".mts-form-field:nth-child(4) .mts-input__field"),
            inputCity = $(".mts-input:nth-child(1) > .mts-input__field"),
            inputCityWrapper = $(".autocomplete-list-wrap"),
            inputResumeLink = $(".form-field-resume-link .mts-input__field"),
            selectResumeFile = $(".mts-dropzone .mts-dropzone__input-link"),
            inputCoverLetter = $(".mts-input__textarea"),
            agreementCheckBox = $("label.mts-checkbox input[type='checkbox']"),
            respondButton = $("#app > div.wrapper > div:nth-child(2) > div > div:nth-child(4) > section > div > div:nth-child(2) > div > div:nth-child(3) > div > button > span.mts-button__text"),
            scrollToButtonRespond = $$(".title").findBy(text("Отклик на вакансию"));

    @Step("Нажимаем кнопку отправить отклик")
    public VacancyMtsPage clickButtonRespond() {
        buttonRespond.click();
        return this;
    }

    @Step("Вводим имя")
    public VacancyMtsPage setFirstName(String value) {
        inputFirstName.click();
        inputFirstName.setValue(value);
        return this;
    }

    @Step("Вводим фамилию")
    public VacancyMtsPage setLastName(String value) {
        inputLastName.setValue(value);
        return this;
    }

    @Step("Вводим номер телефона")
    public VacancyMtsPage setPhoneNumber(String value) {
        inputPhone.setValue(value);
        return this;
    }

    @Step("Вводим email")
    public VacancyMtsPage setEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    @Step("Выбираем город")
    public VacancyMtsPage setCity(String value) {
        inputCity.click();
        inputCity.setValue(value);
        inputCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Прикрепляем ссылку на резюме")
    public VacancyMtsPage linkResume(String value) {
        inputResumeLink.setValue(value);
        return this;
    }

    @Step("Загружаем файл с резюме")
    public VacancyMtsPage uploadResumeFile(String value) {
        selectResumeFile.uploadFromClasspath(value);
        return this;
    }

    @Step("Пишем сопроводительное письмо")
    public VacancyMtsPage setCoverLetter(String value) {
        inputCoverLetter.setValue(value);
        return this;
    }

    @Step("Отмечаем чек-бокс о персональных данных")
    public VacancyMtsPage setAgreementCheckBox() {
        executeJavaScript("arguments[0].click();", agreementCheckBox);
        return this;
    }

    @Step("Проверяем кликабельность кнопки отправить заявку")
    public VacancyMtsPage checkButtonSendRespond() {
        respondButton.shouldBe(clickable);
        return this;
    }

    @Step("Нажимаем на кнопку отправить заявку")
    public VacancyMtsPage clickButtonSendRespond() {
        respondButton.click();
        return this;
    }

    @Step("Пролистываем страницу до кнопки отправить заявку")
    public VacancyMtsPage scrollToButtonRespond() {
        scrollToButtonRespond.scrollTo();
        return this;
    }

    @Step("Нажимаем подтвердить на сообщение о cookies")
    public void closeCookieBannerIfPresent() {
        // Ищем баннер и проверяем, что он существует
        SelenideElement cookieBanner = $(".cookies-agreement-alert");

        // Если баннер существует, пытаемся закрыть его
        if (cookieBanner.exists()) {
            // Находим кнопку "Принимаю" и ждем, пока она станет видимой и доступной для клика
            SelenideElement acceptButton = cookieBanner.$(".mts-button__text");
            acceptButton.shouldBe(Condition.visible).click();  // Ожидаем, пока кнопка станет видимой
        }
    }

    @Step("Проверяем заполненность полей формы")
    public VacancyMtsPage verifyFieldsState(
            boolean isFirstNameFilled,
            boolean isLastNameFilled,
            boolean isPhoneFilled,
            boolean isEmailFilled,
            boolean isCityFilled,
            boolean isResumeLinkFilled,
            boolean isCoverLetterFilled) {

        // Проверяем каждое поле по флагу
        assertEquals(isFirstNameFilled, !inputFirstName.getValue().isEmpty(), "Поле 'Имя' не соответствует ожиданию");
        assertEquals(isLastNameFilled, !inputLastName.getValue().isEmpty(), "Поле 'Фамилия' не соответствует ожиданию");
        assertEquals(isPhoneFilled, !inputPhone.getValue().isEmpty(), "Поле 'Телефон' не соответствует ожиданию");
        assertEquals(isEmailFilled, !inputEmail.getValue().isEmpty(), "Поле 'Email' не соответствует ожиданию");
        assertEquals(isCityFilled, !inputCity.getValue().isEmpty(), "Поле 'Город' не соответствует ожиданию");
        assertEquals(isResumeLinkFilled, !inputResumeLink.getValue().isEmpty(), "Поле 'Ссылка на резюме' не соответствует ожиданию");
        assertEquals(isCoverLetterFilled, !inputCoverLetter.getValue().isEmpty(), "Поле 'Сопроводительное письмо' не соответствует ожиданию");

        return this;
    }

    @Step("Проверяем, что чек-бокс о персональных данных установлен")
    public VacancyMtsPage assertAgreementCheckBoxSelected(boolean expectedState) {
        boolean isCheckBoxSelected = agreementCheckBox.isSelected();
        assertEquals(expectedState, isCheckBoxSelected,
                "Чек-бокс о персональных данных не в ожидаемом состоянии.");
        return this;
    }
}


