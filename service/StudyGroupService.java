package service;

import model.Student;
import model.StudyGroup;
import model.Teacher;

import java.util.List;

public class StudyGroupService {
    public List<Student> gerStudentList(StudyGroup group) {
        return group.getStudentList();
    }

    public Teacher getTeacher(StudyGroup group) {
        return group.getTeacher();
    }
}
