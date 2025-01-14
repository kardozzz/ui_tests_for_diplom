package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.JobMtsMainPage;

import static io.qameta.allure.Allure.step;

@Tag("Smoke")
public class JobMtsMainPageTests extends TestBase {
    JobMtsMainPage jobMtsMainPage = new JobMtsMainPage();
    @Tag("Smoke")
    @DisplayName("Проверяем кликабельность кнопки Стажировки")
    @Test
    void programTest() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        step("Проверяем кликабельность кнопки " + "Стажировки", () -> {
            jobMtsMainPage.checkButtonProgram();
        });
    }
    @DisplayName("Проверяем кликабельность кнопки Все вакансии")
    @Test
    void vacancyTest() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        step("Проверяем кликабельность кнопки " + "Вакансии", () -> {
            jobMtsMainPage.checkButtonAllVacancy();

        });
    }

    @DisplayName("Проверяем кликабельность кнопки Работа в IT")
    @Test
    void workInItTest() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        step("Проверяем кликабельность кнопки " + "Работа в IT", () -> {
            jobMtsMainPage.checkButtonWorkInIt();

        });
    }
    @DisplayName("Проверяем кликабельность кнопки Найти")
    @Test
    void searchButtonTest() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        step("Проверяем кликабельность кнопки " + "Найти", () -> {
            jobMtsMainPage.checkButtonSearch();

        });
    }
    @DisplayName("Проверяем кликабельность ссылки на Habr в карусели")
    @Test
    void habrLinkTest() {
        step("Открываем главную страницу", () -> {
            jobMtsMainPage.pageOpen();
        });
        jobMtsMainPage.scrollToResultSearch();
        step("Проверяем кликабельность ссылка на " + "Habr", () -> {
            jobMtsMainPage.checkSelectHabr();

        });
    }
}





