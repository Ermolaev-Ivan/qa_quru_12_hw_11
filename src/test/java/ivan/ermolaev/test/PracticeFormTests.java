package ivan.ermolaev.test;

import io.qameta.allure.Owner;
import ivan.ermolaev.pages.RegistrationPage;
import ivan.ermolaev.utils.FakeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class PracticeFormTests  extends TestBase {

    @Test
    @Owner("Ermolaev Ivan")
    @DisplayName("Test Practice Form")
    void formTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        FakeData fakeData = new FakeData();

        String firstName = fakeData.firstName,
                lastName = fakeData.lastName,
                email = fakeData.email,
                gender = "Male",
                phone = fakeData.phone,
                day = "19",
                mount = "November",
                year = "1998",
                subjects = "Hindi",
                currentAdress = fakeData.fullAddress,
                state = "Rajasthan",
                city = "Jaiselmer",
                picture = "Gordon.jpg",
                hobby = "Sports";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .choiceGender(gender)
                .setPhone(phone)
                .setBirthDate(day, mount, year)
                .setSubjects(subjects)
                .choiceHobbyCheckbox(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAdress)
                .setState(state)
                .setCity(city)
                .sendFormButton()
                .validationForm(firstName, lastName, email, gender, phone,
                        day, mount, year, subjects, hobby, picture,
                        currentAdress, state, city)
                .closeModal();
    }
}