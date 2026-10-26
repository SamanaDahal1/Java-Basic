package ProjectTaskManagement;

import java.util.List;

public class AssignAction implements Undoable {
    Task task;
    User oldAssignee;
    List<Task> oldAssigneeTaskList;
    List<Task> newAssigneeTaskList;
    AssignAction(Task task,User oldAssignee,List<Task> oldAssigneeTaskList, List<Task> newAssigneeTaskList){
        this.task=task;
        this.oldAssignee=oldAssignee;
        this.oldAssigneeTaskList=oldAssigneeTaskList;
        this .newAssigneeTaskList=newAssigneeTaskList;
    }
    @Override
    public void undo() {
        newAssigneeTaskList.remove(task);
        oldAssigneeTaskList.add(task);
        task.setAssignee(oldAssignee);
    }
}
