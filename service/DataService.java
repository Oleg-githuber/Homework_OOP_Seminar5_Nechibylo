package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList;

    public DataService() {
        this.userList = new ArrayList<>();
    }

    // Создание нового юзера
    public void createUser(Type type, String lastName, String firstName, String secondName) {
        if (type == Type.Student) {
            Student student = new Student(getFreeID(Type.Student), lastName, firstName, secondName);
            userList.add(student);
        } else if (type == Type.Teacher) {
            Teacher teacher = new Teacher(getFreeID(Type.Teacher), lastName, firstName, secondName);
            userList.add(teacher);
        } else {
            System.out.println("Такого типа нет!");
        }
    }

    // генерация ID для каждого типа отдельно
    private int getFreeID(Type type) {
        int id = 0;
        for (User user : userList) {
            if ((user instanceof Teacher) && (type == Type.Teacher)) {
                id = ((Teacher)user).getTeacherID();
            } else if ((user instanceof Student) && (type == Type.Student)) {
                id = ((Student)user).getStudentID();
            }
        }
        return ++id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                studentList.add((Student)user);
            }
        }
        return studentList;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachertList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teachertList.add((Teacher) user);
            }
        }
        return teachertList;
    }
}
