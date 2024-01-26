package creational.builder;

import java.util.List;

public class Person {
     /**
      *  Builder pattern is a creational pattern, which helps in creating the complex object in a step by step process.
      *  Lets say there is a humengous class, which has many fields, then it has two problems
      *  1. The constructor will be overloaded with many arguments, and the order of the parameters should be remembered
      *  2. Let's say you want to initialise few fields, then there might be a chance of an exception
      *     you want to initialise firstName, lastName, email
      *     Person(String fName,String lName, String email);
      *     You want to initialise the other few fields, like fName,lName and phoneNumber this time
      *     Person(String fName,String lName, String phoneNumber);
      *     Since both the constructor has same type of arguments, then it will throw an exception.
      *  3. Let's say in that humengous class, some are optional and mandatory fields. Since, we are using an constructor,
      *     we need to pass explicitly null to those optional fields...
      *  Brute-force Solution:
      *  1. Can use setters to set the properties instead of constructor. But with setters, once the object is created, still the
      *  values of the object can be changed. Therefore, the object is not immutable.
      *  Proper solution:
      *  1. can use builder pattern in this scenario.
      *  2. A PersonBuilder class can be created, with list of all properties of person class, using the setters, we can initialise
      *  values of PersonBuilder class.
      *  3. Using these values, we can create an object of person class.
      *
       **/
     //mandatory fields
     private String firstName;
    private String email;
    //optional fields
    private String lastName;
    private String phoneNumber;
    private String address;
    private List<String> hobbies;

    Person(PersonBuilder personBuilder){
     this.firstName = personBuilder.firstName;
        this.email = personBuilder.email;
        this.lastName = personBuilder.lastName;
        this.phoneNumber = personBuilder.phoneNumber;
        this.address = personBuilder.address;
        this.hobbies = personBuilder.hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public static class PersonBuilder{
        private String firstName;
        private String email;
        private String lastName;
        private String phoneNumber;
        private String address;
        private List<String> hobbies;
        // create or assign mandatory fields via constructor
        public PersonBuilder(String firstName, String email) {
            this.firstName = firstName;
            this.email = email;
        }
        // create a setter method for all fields, whose return type is builder class
        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }
        // create a build method, which builds the Person object
        public Person build(){
            return new Person(this);
        }
    }

}
