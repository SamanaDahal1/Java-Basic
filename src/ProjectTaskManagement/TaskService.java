package ProjectTaskManagement;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private final Map<Project, List<Task>> projectTasks = new HashMap<>();
    private final ActivityLogger activityLogger;

    public TaskService(ActivityLogger activityLogger) {
        this.activityLogger = activityLogger;
    }


    public Task createTask(int id, String title, String description, User assignee, Priority priority, LocalDate deadline,Project project){
      if(!project.getMembers().contains(assignee)){
          throw new  UserNotInProjectException("User is not a member of this project");
      }
      Task task = new Task(id,title,description,assignee,priority,deadline,project);
      projectTasks.computeIfAbsent(project,p-> new ArrayList<>());
      projectTasks.get(project).add(task);
      activityLogger.log(project,"Task created: "+title);
     return task;
    }
    public Optional<Task> findTaskById(int id){
       return projectTasks.values().stream()
                .flatMap(a->a.stream())
                .filter(b->b.getId()==id)
                .findFirst();
    }
    public void assignTask(int taskId, User newAssignee){
       Task task=findTaskById(taskId)
               .orElseThrow(()->new TaskNotFoundException("Task Not FoundException"));
        Project project = task.getProject();

        if (!project.getMembers().contains(newAssignee)) {
            throw new UserNotInProjectException("User is not a member of this project");
        }
        task.setAssignee(newAssignee);

        activityLogger.log(
                project,
                "Task assigned to: " + newAssignee.getName()
        );

    }
}
