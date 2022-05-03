package ivan.ermolaev.pages;

import com.codeborne.selenide.SelenideElement;
import ivan.ermolaev.pages.components.CalendarComponent;
import ivan.ermolaev.test.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage{

    String url_page_form = "/automation-practice-form";

    SelenideElement
        firstNameInput =  $("#firstName"),
        lastNameInput =  $("#lastName"),
        firstUserEmailInput =  $("#userEmail"),
        genderRadio = $("#genterWrapper"),
        userPhoneInput =  $("#userNumber"),
        subjectsInput =  $("#subjectsInput"),
        hobbiesCheckbox = $("#hobbiesWrapper"),

    // Picture
        uploadPictureInput = $("input[id='uploadPicture']"),

    // State and city
        currentAddressInput = $("#currentAddress"),
        stateAddressInput = $("#react-select-3-input"),
        cityAddressInput = $("#react-select-4-input"),

        submitButton = $("#submit"),
        modalForm = $("#example-modal-sizes-title-lg"),
        modalTable = $(".table"),
        closeLargeModalButton = $("#closeLargeModal");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage openPage() {
        open(url_page_form);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setEmail(String email){
        firstUserEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage choiceGender(String gender){
            genderRadio.$(byText(gender)).click();
            return this;
    }

    public RegistrationPage setPhone(String phone){
        userPhoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage choiceHobbyCheckbox(String hobby){
            hobbiesCheckbox.$(byText(hobby)).click();
            return this;
    }


    public RegistrationPage uploadPicture(String namePicture){
        uploadPictureInput.uploadFromClasspath(namePicture);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address){
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state){
        stateAddressInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city){
        cityAddressInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage sendFormButton(){
        submitButton.scrollTo().click();
        return this;
    }

    public RegistrationPage closeModal(){
        closeLargeModalButton.scrollTo().click();
        modalForm.shouldNotBe(visible);
        return this;
    }

    public RegistrationPage validationForm(String firstName, String lastName, String email,
                                           String gender, String phone, String day,
                                           String month, String year,
                                           String subject, String hobby, String picture,
                                           String address, String state, String sity){
        modalForm.shouldBe(visible);
        modalTable.shouldHave(text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(phone),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobby),
                text(picture),
                text(address),
                text(state + " " + sity));
        return this;
    }

}
