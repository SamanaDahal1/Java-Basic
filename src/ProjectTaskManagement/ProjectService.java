package ProjectTaskManagement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProjectService {
    private final Map<Integer, Project> projects = new HashMap<>();
    private  final ActivityLogger activityLogger;
    public ProjectService(ActivityLogger activityLogger){
        this.activityLogger = activityLogger;
    }
    public Project createProject (int id, String name){
        Project project = new Project(id,name);
        projects.put(id,project);
        activityLogger.log(project,"Project Created");
        return project;
    }
    public Project findProjectById(int id) {
        return projects.get(id);
    }
    public void addMember(int projectId, User user){
            Project project = findProjectById(projectId);
            project.addMember(user);
            activityLogger.log(project,"Member Added: " + user.getName() +"("+ user.getRole()+")");
    }
    public Collection<Project> getAllProject (){
        return projects.values();
    }

}
