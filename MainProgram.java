import controller.Controller;
import model.StudyGroup;

import java.util.ArrayList;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("Иванов", "Иван", "Иванович");
        controller.createStudent("Петров", "Пётр", "Петрович");
        controller.createStudent("Сидоров", "Сидор", "Сидорович");
        controller.createTeacher("Васильев", "Василий", "Васильевич");
        controller.createStudent("Васечкин", "Василий", "Васильевич");
        controller.createStudent("Александров", "Александр", "Александрович");
        controller.createTeacher("Алексеев", "Алексей", "Алексеевич");
        List<StudyGroup> list = controller.createGroups();
        controller.printGroups(list);
    }
}
