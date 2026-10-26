package ProjectTaskManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskService {
    private final Map<Project, List<Task>> projectTasks = new HashMap<>();
    private final ActivityLogger activityLogger;
    private final Map<User,List<Task>> userTask= new HashMap<>();
    UndoStack<Undoable> undoStack = new UndoStack<>();

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
      userTask.computeIfAbsent(assignee,p->new ArrayList<>());
      userTask.get(assignee).add(task);

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
        User oldAssignee = task.getAssignee();

        if (!project.getMembers().contains(newAssignee)) {
            throw new UserNotInProjectException("User is not a member of this project");
        }
        List<Task> oldAssigneeTaskList = userTask.get(oldAssignee);
        oldAssigneeTaskList.remove(task);
        task.setAssignee(newAssignee);
        userTask.computeIfAbsent(newAssignee,p->new ArrayList<>());
        List<Task> newAssigneeTaskList = userTask.get(newAssignee);
        newAssigneeTaskList.add(task);

        AssignAction assignAction= new AssignAction(task,oldAssignee,oldAssigneeTaskList,newAssigneeTaskList);
        undoStack.push(assignAction);
        activityLogger.log(
                project,
                "Task assigned to: " + newAssignee.getName()
        );
    }
    public void changeStatus(int taskId, Status newStatus)
            throws InvalidStatusTransitionException {

        Task task = findTaskById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        Status currentStatus = task.getStatus();

        if (!currentStatus.canTransitionTo(newStatus)) {
            throw new InvalidStatusTransitionException(
                    "Cannot change status from " + currentStatus + " to " + newStatus
            );
        }

        task.setStatus(newStatus);
        StatusChangeAction statusChangeAction = new StatusChangeAction(task,currentStatus);
        undoStack.push(statusChangeAction);

        activityLogger.log(
                task.getProject(),
                "Task status changed from " + currentStatus + " to " + newStatus
        );
    }
    public List<Task> filterTasks (Predicate<Task> predicate){
        return projectTasks.values().stream()
                .flatMap(List::stream)
                .filter(predicate)
                .toList();
    }
    public Predicate<Task> byAssignee(User assignee){
        return task -> task.getAssignee().equals(assignee);

    }
    public Predicate<Task> byStatus(Status status){
        return task -> task.getStatus()==status;

    }
    public Predicate<Task> byPriority(Priority priority){
        return task -> task.getPriority()==priority;

    }
    public Predicate<Task> overdue(){
        return task -> task.getDeadline().isBefore(LocalDate.now())
                &&
                (task.getStatus()!=Status.DONE);

    }
    public List<Task> filterBy(Predicate<Task>... predicate){
       Predicate<Task> combine =Filter.all(predicate);
       return filterTasks(combine);

    }
    public List<Task> sortByDeadline(){
       return projectTasks.values().stream()
               .flatMap(List::stream)
               .sorted(Comparator.comparing(Task::getDeadline))
               .toList();
    }
    public List<Task> sortByPriorityThenDeadline(){
        return projectTasks.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Task::getPriority)
                        .reversed()
                        .thenComparing(Task::getDeadline))
                .toList();
    }
    public List<Task> sortByTitle (){
        return projectTasks.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Task::getTitle))
                .toList();
    }
    public long getOpenTaskCount (User user){
       return userTask.getOrDefault(user,new ArrayList<>())
                .stream()
                .filter(a->a.getStatus()!=Status.DONE)
                .count();

    }
    public Optional<LocalDate> getNearestDeadline (User user){
        return userTask.getOrDefault(user,new ArrayList<>())
                .stream()
                .filter(i->i.getStatus()!=Status.DONE)
                .map(Task::getDeadline)
                .min(Comparator.naturalOrder());

    }
    public Predicate<Task> dueNext7Days(){
        LocalDate todayDate =LocalDate.now();
        return task-> {
            long day = ChronoUnit.DAYS.between(todayDate, task.getDeadline());
           return day>=0 && day<=7;
        };
    }
    public List<Project> projectsWithNoOpenTasks (Collection<Project> projects){
        return projects.stream()
                .filter(project -> projectTasks.getOrDefault(project,new ArrayList<>())
                        .stream()
                        .noneMatch(task-> task.getStatus()!=Status.DONE))
                .toList();

    }
    public void deleteTask(int taskId){
        Task task = findTaskById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not Found"));
        Project project = task.getProject();
        User assignee = task.getAssignee();
        List<Task> projectTaskList= projectTasks.get(project);
        projectTaskList.remove(task);
        List<Task> userTaskList= userTask.get(assignee);
        userTaskList.remove(task);
        DeleteAction deleteAction = new DeleteAction(task,projectTaskList,userTaskList);
        undoStack.push(deleteAction);
        activityLogger.log(project,"Task deleted: "+task.getTitle());

    }
    public  void undoLastAction(){
        undoStack.undo();
    }
    Map<Status,Long> getTaskCountByStatus (Project project){
        List<Task> tasks = projectTasks.getOrDefault(project,new ArrayList<>());
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus,()->new EnumMap<>(Status.class) ,Collectors.counting()));
    }
    double getCompletionPercentage(Project project){
        List<Task> tasks = projectTasks.getOrDefault(project,new ArrayList<>());
        int totalTask = tasks.size();
        if (totalTask == 0){
            return 0.0;
        }
        else {
        double completedTasks =tasks.stream()
                .filter(task -> Status.DONE==task.getStatus())
                .count();
            return (completedTasks / totalTask * 100);
        }
    }
    Optional<User> getBusiestMember(Project project){
        List<Task> tasks = projectTasks.getOrDefault(project,new ArrayList<>());
       return tasks.stream()
                .filter(i->i.getStatus()!=Status.DONE)

                .collect(Collectors.groupingBy(Task::getAssignee,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry->entry.getValue()))
                .map(Map.Entry::getKey);
    }
    <R> List<R> transformTasks(Function<Task,R> function){
         return projectTasks.values().stream()
                  .flatMap(List::stream)
                  .map(function)
                  .toList();

    }
    void forEachTask(Consumer<Task> consumer){
        projectTasks.values().stream()
                .flatMap(List::stream)
                .forEach(consumer);
    }
    void exportProjectSummary(Project project,String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("Project: "+project.getName());
            writer.newLine();
            writer.write("Task Count By Status: "+getTaskCountByStatus(project));
            writer.newLine();
            writer.write("Completion Percentage: "+getCompletionPercentage(project));
            writer.newLine();
            writer.write("Busiest Member: "+ getBusiestMember(project)
                    .map(User::getName)
                    .orElse("None"));
        }
    }
}


