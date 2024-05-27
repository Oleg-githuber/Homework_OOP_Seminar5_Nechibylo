package model;

public class Teacher extends User{
    private int teacherID;
    public Teacher(int id, String lastName, String firstName, String secondName) {
        super(firstName, secondName, lastName);
        this.teacherID = id;
    }

    public int getTeacherID() {
        return teacherID;
    }

    @Override
    public String toString() {
        return String.format("Учитель №%d: %s", this.teacherID, super.toString());
    }
}
