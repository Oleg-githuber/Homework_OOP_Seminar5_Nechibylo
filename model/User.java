package model;

public abstract class User {
    String lastName;    // Фамилия
    String firstName;   // Имя
    String secondName;  // Отчество


    // Конструктор
    public User(String lastName, String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("{фамилия: %s, имя: %s, отчество: %s}", this.lastName, this.firstName, this.secondName);
        //return "{фамилия: " + this.lastName + ", имя: " + this.firstName + ", отчество: " + this.secondName + "}";
    }
}
