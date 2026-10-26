package ProjectTaskManagement;

public class StatusChangeAction implements Undoable{
    Task task;
    Status oldStatus;
    StatusChangeAction(Task task , Status oldStatus){
        this.task=task;
        this.oldStatus=oldStatus;
    }
    @Override
    public void undo() {
        task.setStatus(oldStatus);
    }
}
