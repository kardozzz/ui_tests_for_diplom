package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class BrowserNavigation {
    @Step("Перейти но открывшуюся вкладку")
    public BrowserNavigation moveToTwoWindow(){
        switchTo().window(1);
        return this;
    }
}
