package model;

import java.util.List;

public class StudyGroup {
    private int groupID;
    private Teacher teacher;
    private List<Student> studentList;

    public Teacher getTeacher() {
        return teacher;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID() {
        this.groupID = getTeacher().getTeacherID();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
