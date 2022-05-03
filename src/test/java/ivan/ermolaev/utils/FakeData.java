package ivan.ermolaev.utils;

import com.github.javafaker.Faker;



public class FakeData {

    Faker faker = new Faker();
// пока не используемое
//    public static String randomGender(){
//        String[] genders = new String[] {"Male", "Female", "Other"};
//        int randomNumber = (int) (Math.random() * genders.length);
//        return genders[randomNumber];
//    }
//    public static String randomCheckboxes(){
//        String[] checkboxs = new String[] {"Sports", "Reading", "Music"};
//        int randomNumber = (int) (Math.random() * checkboxs.length);
//        return checkboxs[randomNumber];
//    }

//    faker data
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String fullAddress = faker.address().fullAddress();



}


