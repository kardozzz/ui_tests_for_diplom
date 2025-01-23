# Тесты для сайта job.mts.ru

<img src="images/logoMts.jpg" width="900">

## Содержание

* <a href="#tests">Что проверяют тесты?</a>
* <a href="#jenkins">Jenkins</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
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
<a href="(https://qameta.io/)"><img src="images/logo/AllureTestOps.svg" width="50" height="50"  alt="AllureTestOps"/></a>
</p>

---
<a id="tests"></a>
## <a name="Что проверяют тесты?">**Что проверяют тесты?**</a>

9 тестов на проверки верхнеуровнего функционала [сайта](https://job.mts.ru/). Тесты проверяют кликабельность кнопок и отправку отлика по вакансии.

---

<a id="tools"></a>
## <a name="Jenkins:">**Jenkins**</a>

Тесты запускаются через [Jenkins](https://jenkins.autotests.cloud/job/mtsJob_tests/)

<img src="images/jenkins.png" width="900">

Для запуска тестов необходимо нажать на кнопку "Build with Parameters". Появится прогресс бар с номером сборки тестов.

---
## Команды для запуска из терминала
___
***Запуск через терминал IDEA:***
```bash  
gradle clean mtsjob_test -Denv=local
```
```bash  
gradle clean mtsjob_test -Denv=remote
```

***Удалённый запуск через Jenkins:***
```bash  
clean
mtsjob_test 
-DbrowserSize=${BROWSER_SIZE}
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DremoteURL=${REMOTE_URL}
-DremoteVideoURL=${REMOTE_VIDEO_URL}
```
---

<a id="allure"></a>
## <a name="Отчет в Allure">**Отчет в Allure**</a>

После окончания прогона тестов формируется отчет [Allure](https://jenkins.autotests.cloud/job/mtsJob_tests/allure/)

`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и количеством успешных, упавших и сломавшихся в процессе выполнения тестов; <br/>
`TREND` - отображает тенденцию выполнения тестов для всех запусков; <br/>
`SUITES` - отображает распределение тестов по сьютам. <br/>
### На скриншоте результаты отчета десяти тестов:

<img src="images/allure1.png" width="900">

>Есть возможность просмотреть более детальный отчет, нажав на тестовый набор и откроются названия всех тестов

<img src="images/allure2.png" width="900">

>При нажатии на определенный тест, раскрываются шаги теста с приложенными вложениями

<img src="images/allure3.png" width="900">

---
<a id="testops"></a>
## Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4561/dashboards">Allure TestOps</a></b>
>Allure TestOps — это инструмент для управления тестированием, который помогает автоматизировать и оптимизировать процессы тестирования.

Основные функции:
Управление тестами: создание, редактирование и удаление тестов, организация их в тестовые наборы.

Интеграция с CI/CD: поддержка популярных систем непрерывной интеграции и доставки, таких как Jenkins, GitLab CI, Travis CI и другие.
Анализ результатов: сбор и визуализация результатов тестирования, создание отчетов и дашбордов.
Управление дефектами: интеграция с системами управления дефектами, такими как Jira, для отслеживания и управления багами.
Пользовательские роли и права доступа: настройка ролей и прав доступа для различных пользователей и команд.

>Диаграммы прохождения тестов:
> 
<img src="images/dashboardsTestOps.png">
---
<a id="telegramBot"></a>

## Уведомления в Telegram bot

>Для быстрой визуализации отчетности, после выполнения тестов, результат отчета дублируется в Telegram бот:
<p align="center">
    <img src="images/tgBot.png">
</p>

---

<a id="video"></a>
## <a name="Видео прохождения тестов">**Видео прохождения тестов**</a>

<p align="center">
<img title="Selenoid Video" src="images/gifRunTests.gif" width="550" height="360"  alt="video">   
</p>
