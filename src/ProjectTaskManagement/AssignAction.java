package ProjectTaskManagement;

public class AssignAction implements Undoable {
    Task task;
    User oldAssignee;
    AssignAction(Task task,User oldAssignee){
        this.task=task;
        this.oldAssignee=oldAssignee;
    }
    @Override
    public void undo() {
        task.setAssignee(oldAssignee);
    }
}
