package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FindVacancyMtsPage;
import pages.JobMtsMainPage;
import pages.VacancyMtsPage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Smokes")
public class JobMtsResponseVacancyTest extends TestBase {
    FindVacancyMtsPage findVacancyMtsPage = new FindVacancyMtsPage();
    VacancyMtsPage vacancyMtsPage = new VacancyMtsPage();
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();
    String firstName = RandomUtils.getRandomFirstName();
    String lastName = RandomUtils.getRandomLastName();
    String phoneNumber = RandomUtils.getRandomPhoneNumber();
    String email = RandomUtils.getRandomEmail();
    String city = RandomUtils.getRandomCity();
    String resumeFile = RandomUtils.getRandomResumeFormatFile();
    String resumeLink = RandomUtils.getRandomResumeLink();
    String coverLetter = RandomUtils.getRandomCoverLetter();

//    @Test
//    void fillRespondFormResumeFile(){
//        step("Открываем главную страницу", () -> {
//            jobMtsMainPage.pageOpen();
//        });
//        jobMtsMainPage.clickButtonAllVacancy();
//        findVacancyMtsPage.inputVacancy()
//                        .clickFindVacancy();
//        switchTo().window(1);
//        vacancyMtsPage.closeCookieBannerIfPresent();
//        vacancyMtsPage.scrollToButtonRespond()
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setPhoneNumber(phoneNumber)
//                .setEmail(email)
//                .setCity(city)
//                .linkResume(resumeLink)
//                .setCoverLetter(coverLetter)
//                .setAgreementCheckBox()
//                .checkButtonSendRespond();
//    }
    @Test
    void fillRespondFormResumeLink(){
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
                .uploadResumeFile(resumeFile)
                .setCoverLetter(coverLetter)
                .setAgreementCheckBox()
                .checkButtonSendRespond();
    }
}
