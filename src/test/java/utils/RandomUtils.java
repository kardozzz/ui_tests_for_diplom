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

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Unknown City";

        };
    }

    public static String getRandomSubject() {
        return faker.options().option("Math", "English", "Chemistry", "Arts");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports","Reading","Music");
    }

    public static String getRandomDayOfBirth() {
        return String.format("%02d",faker.number().numberBetween(1, 28));
    }

    public static String getRandomMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2100));
    }

    public static String getRandomPicture() {
        return faker.options().option("avatar.jpg","b0721c6e87e1173ad268181c319f709e.jpg","og_og_1508131320299992194.jpg","wyoming-grand-teton-national.jpg");  // Можете расширить для генерации случайных файлов
    }
}

