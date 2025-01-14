package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
            clickAgreementCheckBox = $("label.mts-checkbox input[type='checkbox']"),
            respondButton = $(".mts-form .mts-button .mts-button__text"),
            scrollToButtonRespond = $$(".title").findBy(text("Отклик на вакансию"));


    public VacancyMtsPage clickButtonRespond() {
        buttonRespond.click();
        return this;
    }

    public VacancyMtsPage setFirstName(String value) {
        inputFirstName.click();
        inputFirstName.setValue(value);
        return this;
    }

    public VacancyMtsPage setLastName(String value) {
        inputLastName.setValue(value);
        return this;
    }

    public VacancyMtsPage setPhoneNumber(String value) {
        inputPhone.setValue(value);
        return this;
    }

    public VacancyMtsPage setEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    public VacancyMtsPage setCity(String value) {
        inputCity.click();
        inputCity.setValue(value);
        inputCityWrapper.$(byText(value)).click();
        return this;
    }

    public VacancyMtsPage linkResume(String value) {
        inputResumeLink.setValue(value);
        return this;
    }

    public VacancyMtsPage uploadResumeFile(String value) {
        selectResumeFile.click();
        selectResumeFile.uploadFromClasspath(value);
        return this;
    }

    public VacancyMtsPage setCoverLetter(String value) {
        inputCoverLetter.setValue(value);
        return this;
    }

    public VacancyMtsPage setAgreementCheckBox() {
        executeJavaScript("arguments[0].click();", $("label.mts-checkbox input[type='checkbox']"));
        return this;
    }

    public VacancyMtsPage checkButtonSendRespond() {
        respondButton.shouldBe(clickable);
        return this;
    }

    public VacancyMtsPage scrollToButtonRespond() {
        scrollToButtonRespond.scrollTo();
        return this;
    }

    public void closeCookieBannerIfPresent() {
        $("#app > div.cookies-agreement-alert.container > div > div.col-mob-4.col-xs-offset-1.col-xs-2 > button").click();
    }
}


