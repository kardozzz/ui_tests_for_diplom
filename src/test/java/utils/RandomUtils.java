package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker();  // Создаем объект Faker один раз

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomResumeLink() {
        return faker.options().option("https://hh.ru/resume/45619a8eff22c00e8f0039ed1f7263424e7171", "https://hh.ru/resume/45619a8eff22c00e9f0039ed1f7263424e7171", "https://hh.ru/resume/41619a8eff22c00e8f0039ed1f7263424e7171");
    }

    public static String getRandomResumeFormatFile() {
        return faker.options().option("resume.doc", "resume.docx", "resume.pdf");  // Можете расширить для генерации случайных файлов
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(11);
    }

    public static String getRandomCity() {
        return faker.options().option("Москва");
    }

    public static String getRandomCoverLetter() {
        return faker.options().option("Good afternoon. I think I am ideally suited for your position.", "Good afternoon. I am a good full stack QA.", "Good afternoon. I'm cool.");
    }

}
