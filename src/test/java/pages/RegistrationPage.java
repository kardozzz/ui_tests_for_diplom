package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput = $("#submit"),
            stateCityWrapperInput = $("#stateCity-wrapper");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage pageOpen() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()"); // deleted banner
        executeJavaScript("$('footer').remove()"); // deleted footer
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        if (Configuration.browser.equals("firefox")) return this;
        uploadPicture.scrollTo().uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {

        new ResultTable().checkResult(key, value);
        return this;
    }

    public void checkNegativeResult() {
        new ResultTable().checkNegativeResult();
    }
}

