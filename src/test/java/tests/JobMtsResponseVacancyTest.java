package tests;

import helpers.BrowserHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.FindVacancyMtsPage;
import pages.JobMtsMainPage;
import pages.VacancyMtsPage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("tests")
public class JobMtsResponseVacancyTest extends TestBase {
    final FindVacancyMtsPage findVacancyMtsPage = new FindVacancyMtsPage();
    final VacancyMtsPage vacancyMtsPage = new VacancyMtsPage();
    final BrowserHelper browserHelper = new BrowserHelper();
    final JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();
    final String firstName = RandomUtils.getRandomFirstName();
    final String lastName = RandomUtils.getRandomLastName();
    final String phoneNumber = RandomUtils.getRandomPhoneNumber();
    final String email = RandomUtils.getRandomEmail();
    final String city = RandomUtils.getRandomCity();
    final String resumeLink = RandomUtils.getRandomResumeLink();
    final String coverLetter = RandomUtils.getRandomCoverLetter();


    @ParameterizedTest
    @ValueSource(strings = {"Тестирование", "Разработка", "Поддержка клиентов"})
    @DisplayName("Заполняем все поля формы отклика для вакансии")
    void fillRespondFormAllRow(String vacancyName) {
        jobMtsMainPage.pageOpen();
        jobMtsMainPage.clickButtonAllVacancy();
        sleep(1000);
        findVacancyMtsPage.inputVacancy(vacancyName)
                .clickFindVacancy(vacancyName);
        browserHelper.secondWindow();
        vacancyMtsPage.scrollToButtonRespond()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .closeCookieBannerIfPresent();
        vacancyMtsPage.clickButtonSendRespond()
                .verifyFieldsState(true, true, true, true, true, true, true)
                .assertAgreementCheckBoxSelected(false);
    }

    @DisplayName("Все поля пустые кроме телефона.")
    @ParameterizedTest
    @ValueSource(strings = {"Тестирование"})
    void fillRespondFormResumeLink(String vacancyName) {
        jobMtsMainPage.pageOpen();
        jobMtsMainPage.clickButtonAllVacancy();
        sleep(1000);
        findVacancyMtsPage.inputVacancy(vacancyName)
                .clickFindVacancy(vacancyName);
        browserHelper.secondWindow();
        vacancyMtsPage.scrollToButtonRespond()
                .closeCookieBannerIfPresent();
        vacancyMtsPage.clickButtonSendRespond()
                .verifyFieldsState(false, false, true, false, false, false, false)
                .assertAgreementCheckBoxSelected(false);
    }


    @DisplayName("Имя и фамилия не заполнены.")
    @ParameterizedTest
    @ValueSource(strings = {"Тестирование"})
    void fillRespondFormNotFirstAndLastName(String vacancyName) {
            jobMtsMainPage.pageOpen();
        jobMtsMainPage.clickButtonAllVacancy();
        sleep(1000);
        findVacancyMtsPage.inputVacancy(vacancyName)
                .clickFindVacancy(vacancyName);
        browserHelper.secondWindow();
        vacancyMtsPage.scrollToButtonRespond()
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .setAgreementCheckBox()
                .closeCookieBannerIfPresent();
        vacancyMtsPage.clickButtonSendRespond()
                .verifyFieldsState(false, false, true, true, true, true, true)
                .assertAgreementCheckBoxSelected(true);
    }

    @DisplayName("Не поставлен чек-бокс о персональных данных.")
    @ParameterizedTest
    @ValueSource(strings = {"Тестирование"})
    void fillRespondFormNotCheckBox(String vacancyName) {
        jobMtsMainPage.pageOpen();
        jobMtsMainPage.clickButtonAllVacancy();
        sleep(1000);
        findVacancyMtsPage.inputVacancy(vacancyName)
                .clickFindVacancy(vacancyName);
        browserHelper.secondWindow();
        vacancyMtsPage.scrollToButtonRespond()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setCity(city)
                .linkResume(resumeLink)
                .setCoverLetter(coverLetter)
                .closeCookieBannerIfPresent();
        vacancyMtsPage.clickButtonSendRespond()
                .verifyFieldsState(true, true, true, true, true, true, true)
                .assertAgreementCheckBoxSelected(false);

    }
}


