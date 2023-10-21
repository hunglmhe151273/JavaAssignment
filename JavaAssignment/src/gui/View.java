package gui;

import model.Task;
import model.TaskManager;
import model.Validation;

public class View {

    TaskManager manager = new TaskManager();
    //array of string contains option
    private static String[] options = {
        "Add task",
        "Delete task",
        "Display task",
        "Exit"
    };
    public void menu() {
        System.out.println("========= Task program =========");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
    }

    public void addTask() {
        String name = Validation.getName("Requiredment name :");
        int taskType = Validation.getInt("Task type: ", 1, 4);
        String date = Validation.getDate();
        double from = Validation.getFrom("From:", 8.0, 17);
        double to = Validation.getTo("To:", 8.0, 17.5, from);
        String assignee = Validation.getName("Asignee: ");
        String reviewer = Validation.getName("Review: ");
        int add = manager.addTask(name, taskType, date, from, to, assignee, reviewer);
        if (add == 1) {
            System.out.println("Add success");
        } else {
            System.out.println("Add fail");
        }
    }

    public void deleTask() {
        int id = Validation.getInt("ID:", 1, Integer.MAX_VALUE);
        manager.deleteTask(id);
    }

    public void displayTask() {
        for (Task dataTask : manager.getDataTasks()) {
            System.out.println(dataTask);
        }
    }
    
}
