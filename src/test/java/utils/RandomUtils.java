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
    public static String getRandomMiddleName() {
        return faker.name().nameWithMiddle();
    }
    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }
    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(8);
    }
    public static String getRandomInterest() {
        return faker.options().option("Заинтересован в стажировке на QA Java Automation","Заинтересован в стажировке на QA Engineer Manual", "Заинтересован в стажировке на QA Python Automation");
    }
    public static String getVacancy() {
        return faker.options().option("Middle Auto QA");
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }


}

