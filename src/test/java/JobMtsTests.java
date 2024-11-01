
import org.junit.jupiter.api.Test;
import pages.JobMtsMainPage;

import static io.qameta.allure.Allure.step;


public class JobMtsTests extends TestBase {
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();

    @Test
    void buttonVacancyTest() {
        jobMtsMainPage.pageOpen()
                .checkButtonAllVacancy();
    }
}





