package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.JobMtsMainPage;

@Tag("web")
public class JobMtsMainPageTests extends TestBase {
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();


    @DisplayName("Проверяем кликабельность кнопки Стажировки")
    @Test
    void programTest() {
        jobMtsMainPage.pageOpen()
                .checkButtonProgram();
    }

    @DisplayName("Проверяем кликабельность кнопки Все вакансии")
    @Test
    void vacancyTest() {

        jobMtsMainPage.pageOpen()
                .clickButtonAllVacancy();
    }

    @DisplayName("Проверяем кликабельность кнопки Работа в IT")
    @Test
    void workInItTest() {

        jobMtsMainPage.pageOpen()
                .checkButtonWorkInIt();
    }

    @DisplayName("Проверяем кликабельность кнопки Найти")
    @Test
    void searchButtonTest() {

        jobMtsMainPage.pageOpen()
                .checkButtonSearch();
    }

    @DisplayName("Проверяем кликабельность ссылки на Habr в карусели")
    @Test
    void habrLinkTest() {
        jobMtsMainPage.pageOpen()
                .scrollToResultSearch()
                .checkSelectHabr();


    }
}





