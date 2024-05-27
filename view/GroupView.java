package view;

import model.StudyGroup;

public class GroupView {
    public void printOnConsole(StudyGroup group) {
        System.out.printf("Группа №%d\n", group.getGroupID());
    }
}
