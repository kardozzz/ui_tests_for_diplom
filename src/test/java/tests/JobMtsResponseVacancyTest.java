package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FindVacancyMtsPage;
import pages.JobMtsMainPage;
import pages.VacancyMtsPage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class JobMtsResponseVacancyTest extends TestBase {
    FindVacancyMtsPage findVacancyMtsPage = new FindVacancyMtsPage();
    VacancyMtsPage vacancyMtsPage = new VacancyMtsPage();
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();
    String firstName = RandomUtils.getRandomFirstName();
    String lastName = RandomUtils.getRandomLastName();
    String phoneNumber = RandomUtils.getRandomPhoneNumber();
    String email = RandomUtils.getRandomEmail();
    String city = RandomUtils.getRandomCity();
    String resumeLink = RandomUtils.getRandomResumeLink();
    String coverLetter = RandomUtils.getRandomCoverLetter();

    @Test
    @DisplayName("Заполняем все поля формы отклика")
    void fillRespondFormAllRow() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        jobMtsMainPage.clickButtonAllVacancy();
        findVacancyMtsPage.inputVacancy()
                .clickFindVacancy();
        switchTo().window(1);
        vacancyMtsPage.closeCookieBannerIfPresent();
        vacancyMtsPage.scrollToButtonRespond()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .setAgreementCheckBox()
                .checkButtonSendRespond();
    }

    @DisplayName("Все поля пустые.")
    @Test
    void fillRespondFormResumeLink() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        jobMtsMainPage.clickButtonAllVacancy();
        findVacancyMtsPage.inputVacancy()
                .clickFindVacancy();
        switchTo().window(1);
        vacancyMtsPage.closeCookieBannerIfPresent();
        vacancyMtsPage.scrollToButtonRespond()
                .clickButtonSendRespond();
    }

    @DisplayName("Имя и фамилия не заполнены.")
    @Test
    void fillRespondFormNotFirstAndLastName() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        jobMtsMainPage.clickButtonAllVacancy();
        findVacancyMtsPage.inputVacancy()
                .clickFindVacancy();
        switchTo().window(1);
        vacancyMtsPage.closeCookieBannerIfPresent();
        vacancyMtsPage.scrollToButtonRespond()
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .setAgreementCheckBox()
                .clickButtonSendRespond();
    }

    @DisplayName("Не поставлен чек-бокс о персональных данных.")
    @Test
    void fillRespondFormNotCheckBox() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        jobMtsMainPage.clickButtonAllVacancy();
        findVacancyMtsPage.inputVacancy()
                .clickFindVacancy();
        switchTo().window(1);
        vacancyMtsPage.closeCookieBannerIfPresent();
        vacancyMtsPage.scrollToButtonRespond()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .clickButtonSendRespond();
    }
}


