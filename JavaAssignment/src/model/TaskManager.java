package model;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasklist = new ArrayList<Task>();
    private int autoId = 1;

    public TaskManager() {
        generate();
    }
    public void generate(){
        tasklist.add(new Task(1,"program java", 1, "14-12-2022", 10, 15, "Dev", "Lead"));
        tasklist.add(new Task(2,"program java", 1, "14-12-2022", 16, 17, "Dev", "Lead"));
    }
    
    public int addTask(String name, int taskTypeId, String Date, double from,
            double to, String assignnee, String reviewer)
    {
        Task t = new Task(autoId, name, taskTypeId, Date, from, to, assignnee, reviewer);
        if(isTaskDuplicate(t)){
            System.out.println("Intersect Task");
            return -1;
        }else{
            tasklist.add(t);
            autoId++;
            return 1;
        }
    }
    public void deleteTask(int idDelete)
    {
        boolean isExist = false;
        for (Task t : tasklist) {
            if(t.getId() == idDelete){
                isExist = true;
                tasklist.remove(t);
                System.out.println("Delete success");
                break;
            }
        }
        if(!isExist){
            System.out.println("Delete fail");
        }
    }
    
    public ArrayList<Task> getDataTasks(){
        return (ArrayList<Task>) tasklist;
    }
    private boolean isTaskDuplicate(Task task){
        double taskTo = task.getTo();
        double taskFr = task.getFrom();
        String taskAss = task.getAssignee();
        String taskDate = task.getDate();
        for (Task t: tasklist) {
            if(t.getAssignee().equals(taskAss)&&t.getDate().equals(taskDate)){
                if(taskFr < t.getFrom()){
                    if(taskTo < t.getFrom())
                        continue;//from ...to...t.getFrom()...t.getTo()....
                    else 
                        return true;
                }
                else if(taskFr > t.getTo()) continue;//...t.getFrom()...t.getTo()....from ...to
                else return true;
            }
        }
        return false;
    }
}
