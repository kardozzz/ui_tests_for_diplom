package tests;

import helpers.BrowserHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("Web")
public class JobMtsSocialSliderTests extends TestBase {
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();
    BrowserHelper browserHelper = new BrowserHelper();
    TelegramPage telegramPage = new TelegramPage();
    HabrPage habrPage = new HabrPage();
    VcPage vcPage = new VcPage();
    KodPage kodPage = new KodPage();


    @DisplayName("Проверяем переход в соц.сеть Telegram")
    @Test
    void socialSliderTelegram() {
        jobMtsMainPage.pageOpen()
                .scrollToResultSearch()
                .clickOnTgSlider();
        browserHelper.secondWindow();
        sleep(2000);
        browserHelper.closeTelegramAppDialog();
        telegramPage.checkTgChannelName()
                .checkTgLogo();
    }


    @DisplayName("Проверяем переход в соц.сеть Habr.ru")
    @Test
    void socialSliderHabr() {
        jobMtsMainPage.pageOpen()
                .scrollToResultSearch()
                .clickOnHabrSlider();
        browserHelper.secondWindow();
        habrPage.checkLogoHabr()
                .checkProfileName();
    }

    @DisplayName("Проверяем переход в соц.сеть Vc.ru")
    @Test
    void socialSliderVc() {
        jobMtsMainPage.pageOpen()
                .scrollToResultSearch()
                .clickOnVcSlider();
        browserHelper.secondWindow();
        vcPage.checkNameCompany();

    }

    @DisplayName("Проверяем переход в соц.сеть Kod.ru")
    @Test
    void socialSliderKod() {
        jobMtsMainPage.pageOpen()
                .scrollToResultSearch()
                .clickOnKodSlider();
        browserHelper.secondWindow();
        kodPage.checkAuthorName()
                .checkAuthorDescription();
    }
}
