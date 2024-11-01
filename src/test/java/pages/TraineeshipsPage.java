package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TraineeshipsPage {
    final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            middleNameInput = $("#middleName"),
            phoneInput = $("#phone"),
            emailInput = $("#email"),
            interestInput = $("#interest"),
            scrollToSearchResult = $(".traineeshipExpectations__head--DOlbY"),
            checkBoxSelect = $(".personalDataCheckbox__checkbox--n23eu"),
            sendInput = $("button--XNcty traineeshipExpectations__sendBtn--nD586"),
            selectApplication = $(".traineeshipExpectations--CMj80");


    public TraineeshipsPage pageOpen() {
        open("/career/traineeships");
        return this;
    }

    public TraineeshipsPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()"); // deleted banner
        executeJavaScript("$('footer').remove()"); // deleted footer
        return this;
    }

    public TraineeshipsPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public TraineeshipsPage scrollToResultOfSearch(Boolean value) {
        scrollToSearchResult.scrollIntoView(value);
        return this;
    }

    public TraineeshipsPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public TraineeshipsPage setMiddleName(String value) {
        middleNameInput.setValue(value);
        return this;
    }

    public TraineeshipsPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TraineeshipsPage setPhoneNumber(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public TraineeshipsPage setInterest(String value) {
        interestInput.setValue(value);
        return this;
    }

    public TraineeshipsPage clickCheckBox() {
        checkBoxSelect.click();
        return this;
    }

    public TraineeshipsPage selectApplication() {
        selectApplication.shouldHave(text("Подать заявку")).click();
        return this;
    }

    public TraineeshipsPage checkСlickabilitySendButton() {
        sendInput.shouldNotBe(visible).shouldNotBe(Condition.enabled);
        return this;
    }

}

