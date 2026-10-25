package ProjectTaskManagement;

import java.time.LocalDate;


public class Task {
    private int id;
    private String title;
    private String description;
    private User assignee;
    private Priority priority;
    private Status status;
    private LocalDate deadline;
    private Project project;

    public Task(int id, String title,String description,User assignee,Priority priority,LocalDate deadline,Project project){
        this.id=id;
        this.title=title;
        this.description=description;
        this.assignee=assignee;
        this.priority=priority;
        this.status=Status.TODO;
        this.deadline=deadline;
        this.project=project;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Project getProject() {
        return project;
    }
    void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return"Task:"+"\nID: "+getId()+"\nTitle: "+getTitle()+"\nAssignee: "+getAssignee().getName()+"\nPriority: "+getPriority()+ "\nStatus: " +getStatus()+ "\nDeadline: "+getDeadline()+ "\nProject: "+getProject().getName();
    }
}
