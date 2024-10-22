import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = System.getProperty("remoteUrl");
        Configuration.browser = System.getProperty("browserName");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://" + System.getProperty("login") + "@" + System.getProperty("remote");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
