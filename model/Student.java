package model;

public class Student extends User{
    private int studentID;
    public Student(int id, String lastName, String firstName, String secondName) {
        super(lastName, firstName, secondName);
        this.studentID = id;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return String.format("Студент №%d: %s", this.studentID, super.toString());
    }
}
