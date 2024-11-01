# Тесты для сайта job.mts.ru

<img src="images/mts1.jpg" width="900">

## Содержание

* <a href="#tests">Что проверяют тесты?</a>
* <a href="#jenkins">Jenkins</a>
* <a href="#allure">Отчет в Allure</a>
* <a href="#telegramBot">Уведомления в Telegram bot</a>
* <a href="#video">Видео прохождения тестов</a>

---
## <a name="Технологии:">**Технологии:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
</p>

---
<a id="tests"></a>
## <a name="Что проверяют тесты?">**Что проверяют тесты?**</a>

5 тестов на проверки верхнеуровнего функционала [сайта](https://job.mts.ru/). Тесты проверяют кликабельность кнопок.

---

<a id="tools"></a>
## <a name="Jenkins:">**Jenkins:**</a>

Тесты запускаются через [Jenkins](https://jenkins.autotests.cloud/job/student_alabzin_testOps_in_jenkins/)

<img src="images/jenkins.png" width="900">

Для запуска тестов необходимо нажать на кнопку "Build with Parameters". Появится прогресс бар с номером сборки тестов.

---
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean runing_test
```

***Удалённый запуск через Jenkins:***
```bash  
clean runing_test
"-DbrowserSize=${BROWSER_SIZE}"
"-DbrowserName=${BROWSER_NAME}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-Dremote=${REMOTE_URL}"
"-Dlogin=${REMOTE_LOGIN}"
"-DremoteVideoURL=${REMOTE_VIDEO_URL}"
```
---

<a id="allure"></a>
## <a name="Отчет в Allure">**Отчет в Allure**</a>

После окончания прогона тестов формируется отчет [Allure](https://jenkins.autotests.cloud/job/student_alabzin_testOps_in_jenkins/6/allure)
### На скриншоте результаты отчета пяти тестов:

<img src="images/allure.png" width="900">

Есть возможность просмотреть более детальный отчет, нажав на тестовый набор и откроются названия всех тестов

<img src="images/allure1.png" width="900">

При нажатии на определенный тест, раскрываются шаги теста с приложенными вложениями

<img src="images/allure2.png" width="900">

---

<a id="telegramBot"></a>
## <a name="Уведомления в Telegram bot">**Уведомления в Telegram bot**</a>

Для быстрой визуализации отчетности, после выполнения тестов, результат отчета дублируется в Telegram бот:
<p align="center">
    <img src="images/tgHw.png">
</p>

---

<a id="video"></a>
## <a name="Видео прохождения тестов">**Видео прохождения тестов**</a>

<p align="center">
<img title="Selenoid Video" src="images/video/uptrade.gif" width="550" height="350"  alt="video">   
</p>