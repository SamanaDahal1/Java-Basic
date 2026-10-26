package ProjectTaskManagement;

import PhaseTwoConsoleApplication.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class ProjectTaskManagementApp {
    public static void main(String[] args) {
        ActivityLogger activityLogger = new ActivityLogger();
        ProjectService projectService = new ProjectService(activityLogger);
        TaskService taskService = new TaskService(activityLogger);
        Scanner src = new Scanner(System.in);
        Map<Integer,User> users = new HashMap<>();
        while (true){
            System.out.println("-----------------------------");
            System.out.println("1.Create User\n" +
                    "2. Create Project\n" +
                    "3. Add Member\n" +
                    "4. Create Task\n" +
                    "5. Assign Task\n" +
                    "6. Change Task Status\n" +
                    "7. Delete Task\n" +
                    "8. Filter Tasks\n" +
                    "9. Sort Tasks\n" +
                    "10. View User Workload\n" +
                    "11. View Due/Overdue Tasks\n" +
                    "12. View Activity Log\n" +
                    "13. Undo Last Action\n" +
                    "14. View Project Summary\n" +
                    "15. Export Project Summary\n" +
                    "0. Exit");
            System.out.println("-----------------------------");
            System.out.print("Choose from 0 to 15: ");
            int menuChoice= src.nextInt();
            System.out.println("-----------------------------");
            if (menuChoice == 1) {
                System.out.print("Enter User ID: ");
                int id = src.nextInt();
                if(users.containsKey(id)){
                    System.out.println("User ID already exists");
                }
                else {
                    src.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = src.nextLine();
                    System.out.print("Enter User Role: \n");
                    Role[] roles = Role.values();
                    for (Role role : roles) {
                        System.out.println(role);
                    }
                    Role role= Role.valueOf(src.next().toUpperCase());

                    users.put(id,new User(id,name,role));
                    System.out.println("User Created Successfully");
                }
            }
            else if (menuChoice==2) {
                System.out.print("Enter Project Id: ");
                int projectId= src.nextInt();

                if(projectService.findProjectById(projectId)!=null){
                    System.out.println("Project Id already exists");
                }
                else {
                src.nextLine();
                System.out.print("Enter Project Name: ");
                String projectName = src.nextLine();
                projectService.createProject(projectId,projectName);
                System.out.println("Project Created Successfully");
                }
            }
            else if (menuChoice==3) {
                System.out.print("Enter Project Id: ");
                int projectId= src.nextInt();
                if(projectService.findProjectById(projectId)==null){
                    System.out.println("Project not found");
                }
                else {
                    System.out.print("Enter User Id: ");
                    int userId= src.nextInt();

                    if(users.get(userId)==null){
                        System.out.println("User not found");
                    }
                    else {
                        projectService.addMember(projectId,users.get(userId));
                        System.out.println("Member Added Successfully");
                    }
                }
            }
            else if (menuChoice==4) {
                System.out.print("Enter Task id: ");
                int id = src.nextInt();
                src.nextLine();
                if(taskService.findTaskById(id).isPresent()){
                    System.out.println("Task ID already exists");
                }
                else {
                    System.out.print("Enter Task Title: ");
                    String title = src.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = src.nextLine();
                    System.out.print("Enter Task Assignee: ");
                    int assigneeId = src.nextInt();
                    User assignee = users.get(assigneeId);
                    if(assignee==null){
                        System.out.println("User not found");
                    }
                    else {
                        System.out.print("Enter Task Priority: \n");
                        Priority[] priorities = Priority.values();
                        for (Priority priority : priorities) {
                            System.out.println(priority);
                        }
                        Priority priority = Priority.valueOf(src.next().toUpperCase());
                        System.out.print("Enter Task Deadline:(yyyy/MM/dd): ");
                        String dateString = src.next();
                        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        System.out.print("Enter Project Id: ");
                        int projectId = src.nextInt();
                        Project project = projectService.findProjectById(projectId);
                        if(project==null){
                            System.out.println("Project not Found");
                        }
                        else {
                            taskService.createTask(id,title,description,assignee,priority,date,project);
                            System.out.println("Task Created Successfully");
                        }
                    }
                }
            }
            else if (menuChoice==5) {
                System.out.print("Enter Task Id: ");
                int taskId = src.nextInt();
                System.out.print("Enter new Assigned Id: ");
                int newAssigneeId = src.nextInt();
                User user =users.get(newAssigneeId);
                if(user==null){
                    System.out.println("User not found");
                }
                else {
                    taskService.assignTask(taskId,user);
                    System.out.println("task Assigned Successfully");
                }
            }
            else if (menuChoice==6) {
                System.out.println("Enter Task Id: ");
                int taskId = src.nextInt();
                System.out.print("Enter New Status: \n");
                Status[] statuses = Status.values();
                for (Status status : statuses) {
                    System.out.println(status);
                }

                Status status= Status.valueOf(src.next().toUpperCase());
                try{
                taskService.changeStatus(taskId,status);
                System.out.println("Task Status Changed Successfully");
                } catch (InvalidStatusTransitionException e){
                    System.out.println(e.getMessage());
                }
            }
            else if (menuChoice==7) {
                System.out.print("Enter Task Id: ");
                int taskId = src.nextInt();
                taskService.deleteTask(taskId);
                System.out.println("Task Delete Successfully");
            }
            else if (menuChoice==8) {
                List<Predicate<Task>> filters  = new ArrayList<>();
                while (true) {
                    System.out.println("Select filters one by one. Enter 0 when done.\n" +
                            "\n" +
                            "1. Filter by Assignee\n" +
                            "2. Filter by Status\n" +
                            "3. Filter by Priority\n" +
                            "4. Filter Overdue Tasks\n" +
                            "0. Apply Filters");
                    int filterChoice = src.nextInt();
                    if(filterChoice==0){
                        Predicate<Task>[] filterArray=filters.toArray(new Predicate[0]);
                        List<Task>  filteredTasks = taskService.filterBy(filterArray);
                        for(Task filteredTask: filteredTasks){
                            System.out.println(filteredTask);
                        }
                        break;
                    }
                    else if (filterChoice==1) {
                        System.out.println("Enter Assignee User Id: ");
                        int assignedId = src.nextInt();
                        User assignee = users.get(assignedId);
                        if(assignee==null){
                            System.out.println("User not Found");
                        }
                        else {
                            filters.add(taskService.byAssignee(assignee));
                            System.out.println("Assignee filter added ");
                        }
                    }
                    else if (filterChoice==2) {
                        System.out.print("Selete Status: \n");
                        Status[] statuses = Status.values();
                        for (Status status : statuses) {
                            System.out.println(status);
                        }
                        Status status= Status.valueOf(src.next().toUpperCase());
                        filters.add(taskService.byStatus(status));
                        System.out.println("Status Filter Added");
                    }
                    else if (filterChoice==3) {
                        System.out.print("Select Priority: \n");
                        Priority[] priorities = Priority.values();
                        for (Priority priority : priorities) {
                            System.out.println(priority);
                        }
                        Priority priority = Priority.valueOf(src.next().toUpperCase());
                        filters.add(taskService.byPriority(priority));
                        System.out.println("Priority Filter Added");
                    }
                    else if (filterChoice==4) {
                        filters.add(taskService.overdue());
                        System.out.println("Overdue Filter Added");
                    }
                    else {
                        System.out.println("Please Enter number from 0-4");
                    }
                }

            }
        }

    }
}
