import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "John";
    String lastName = "Krutoy";
    String userEmail = "krutoy@gmail.com";
    String gender = "Male";
    String userNumber = "8911222333";
    String address = "123 Main St, Springfield";
    String state = "NCR";
    String city = "Delhi";
    String subject = "Math";
    String hobbies = "Sports";
    String picture = "avatar.jpg";
    String dayOfBirth = "13";
    String monthOfBirth = "9";
    String yearOfBirth = "1991";

    String monthName = getMonthName(Integer.parseInt(monthOfBirth));


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
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .removeBanner()
                .setState(state)
                .setCity(city)
                .clickSubmit();

        // Проверяем что все заполнилось верно на всплывающем окне.
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthName + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

        // Отбивка что всё ок.
        System.out.println("Форма успешно заполнена, значения соответствуют введеным, окно закрыто.");
    }

    @Test
    void fillRequiredFormTests() {
        registrationPage.pageOpen()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenderWrapper(gender)
                .setUserNumber(userNumber)
                .clickSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void notFillFormNegativeTests() {
        registrationPage.pageOpen()
                .removeBanner()
                .clickSubmit();
        registrationPage.checkNegativeResult();
    }


}
