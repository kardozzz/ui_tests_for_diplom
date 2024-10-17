import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class RegistrationPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = RandomUtils.getRandomFirstName();
    String lastName = RandomUtils.getRandomLastName();
    String userEmail = RandomUtils.getRandomEmail();
    String gender = RandomUtils.getRandomGender();
    String userNumber = RandomUtils.getRandomPhoneNumber();
    String address = RandomUtils.getRandomAddress();
    String state = RandomUtils.getRandomState();
    String city = RandomUtils.getRandomCity(state);
    String subject = RandomUtils.getRandomSubject();
    String hobbies = RandomUtils.getRandomHobbies();
    String picture = RandomUtils.getRandomPicture();
    String dayOfBirth = RandomUtils.getRandomDayOfBirth();
    String monthOfBirth = RandomUtils.getRandomMonthOfBirth();
    String yearOfBirth = RandomUtils.getRandomYearOfBirth();

    @Tag("demoqa")
    @Test
    void fillFullFormTests() {


        // Заполняем форму.
        registrationPage.pageOpen()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGenderWrapper(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setCurrentAddress(address)
                .removeBanner()
                .setHobbies(hobbies)
                .removeBanner()
                .uploadPicture(picture)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        // Проверяем что все заполнилось верно на всплывающем окне.
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

        // Отбивка что всё ок.
        System.out.println("Форма успешно заполнена, значения соответствуют введеным, окно закрыто.");
    }
    @Tag("demoqa")
    @Test
    void fillRequiredFormTests() {
        registrationPage.pageOpen()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenderWrapper(gender)
                .setUserNumber(userNumber)
                .removeBanner()
                .clickSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }
    @Tag("demoqa")
    @Test
    void notFillFormNegativeTests() {
        registrationPage.pageOpen()
                .removeBanner()
                .clickSubmit();
        registrationPage.checkNegativeResult();
    }


}
