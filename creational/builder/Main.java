package creational.builder;

public class Main {
    public static void main(String[] args) {

        Person person = new Person.PersonBuilder("suheab","khansuheab@gmailcom")
                .setLastName("khan")
                .setPhoneNumber("8309525424")
                .build();
        // Here we are not initialiseing few optional fields
        // But we are not passing any null value to it
        // once this person object is build, and crated, we cannot change these values as it is immutable now., because
        // we dont have any setters in the class of person
        System.out.println(person);
    }
}
