package controller;

import model.*;
import service.DataService;
import view.GroupView;
import view.StudentView;
import view.TeacherView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private StudentView studentView = new StudentView();
    private TeacherView teacherView = new TeacherView();
    private GroupView groupView = new GroupView();
    private DataService dataService = new DataService();

    // Создание студента
    public void createStudent(String lastName, String firstName, String secondName) {
        dataService.createUser(Type.Student, lastName, firstName, secondName);
    }

    // Создание учителя
    public void createTeacher(String lastName, String firstName, String secondName) {
        dataService.createUser(Type.Teacher, lastName, firstName, secondName);
    }

    // Печать всех студентов вообще
    public void printStudents() {
        for (Student student : dataService.getAllStudent()) {
            studentView.printOnConsole(student);
        }
    }
    // Перегруженый метод для печати определенного списка студентов
    public void printStudents(List<Student> studentList) {
        for (Student student : studentList) {
            studentView.printOnConsole(student);
        }
    }

    // Печать всех участников учебной группы
    public void printGroups(List<StudyGroup> groups) {
        for (StudyGroup group : groups) {
            groupView.printOnConsole(group);
            TeacherView teacherView1 = new TeacherView();
            teacherView1.printOnConsole(group.getTeacher());
            System.out.println("Студенты:");
            printStudents(group.getStudentList());
            System.out.println();
        }
    }

    // Количество учителей в списке
    private int teachersValue() {
        int count = 0;
        for (User user : dataService.getUserList()) {
            if (user instanceof Teacher) count++;
        }
        return count;
    }

    // Количество студентов всего
    private int studentsValue() {
        return dataService.getAllStudent().size();
    }

    // Количество студентов в группе
    private int studentsInGroup() {
        return (studentsValue() / teachersValue());
    }

    // Создание списка групп (учитель и список студентов)
    public List<StudyGroup> createGroups() {
        int groupsValue = teachersValue();
        int studValue = studentsValue();
        int studInG = studentsInGroup();
        List<StudyGroup> list = new ArrayList<>();
        for (int i = 0; i < groupsValue; i++) {
            StudyGroup group = new StudyGroup();
            List<Student> studentList = new ArrayList<>();
            for (int j = i * studInG; j < (i + 1) * studInG; j++) {
                studentList.add(dataService.getAllStudent().get(i + j));
                if (i == groupsValue - 1) {     // Для последнего учителя
                    for (int k = j + i + 1; k < studValue; k ++) {  // Если число всех студентов не кратно числу учителей, то добавляем остатки студентов последнему учителю
                        studentList.add(dataService.getAllStudent().get(i * j));
                    }
                }
            }
            group.setStudentList(studentList);
            group.setTeacher(dataService.getAllTeachers().get(i));
            group.setGroupID();
            list.add(group);
        }
        return list;
    }
}
