package ProjectTaskManagement;

import java.util.List;

public class DeleteAction implements Undoable{
    Task task;
    List<Task> projectTaskList;
    List<Task> userTaskList;
    DeleteAction(Task task,List<Task> projectTaskList,List<Task> userTaskList){
        this.task=task;
        this.projectTaskList=projectTaskList;
        this.userTaskList=userTaskList;
    }


    @Override
    public void undo() {
        projectTaskList.add(task);
        userTaskList.add(task);
    }
}
