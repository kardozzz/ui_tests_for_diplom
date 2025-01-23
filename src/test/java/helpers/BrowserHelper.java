package helpers;

import io.qameta.allure.Step;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.switchTo;

public class BrowserHelper {
    @Step("Перейти но открывшуюся вкладку")
    public BrowserHelper secondWindow() {
        switchTo().window(1);
        return this;
    }

    @Step("Закрыть диалоговое окно Telegram")
    public BrowserHelper closeTelegramAppDialog() {
        try {


            // Используем Robot для имитации нажатия клавиши Enter или Esc для закрытия всплывающего окна
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE); // Нажатие на ESC для закрытия окна
            robot.keyRelease(KeyEvent.VK_ESCAPE);

        } catch (AWTException e) {
            System.out.println("Ошибка при имитации нажатия клавиши: " + e.getMessage());
        }
        return this;
    }
}
