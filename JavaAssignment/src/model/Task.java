
package model;

public class Task {
    private int id;
    private String name;
    private int taskTypeId;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String name, int taskTypeId, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.taskTypeId = taskTypeId;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    
    
    private String getTypeName(){
        switch(taskTypeId){
            case 1: return "Code";
            case 2: return "Test";
            case 3: return "Design";
            case 4: return "Review";
        }
        return null;
    }
    private double getTime(){
        return (to - from);
    }
    @Override
    public String toString() {
        return String.format("%-8d | %-8s | %-8s | %-8s |%-8.2f | %-8.2f | %-8.2f | %-8s | %-8s"
                ,id,name,getTypeName(),date,from,to,getTime(),assignee,reviewer); 
    }
    
    
    
    
}
