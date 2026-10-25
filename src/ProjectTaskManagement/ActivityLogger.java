package ProjectTaskManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ActivityLogger {
    private final Map<Project, LinkedList<ActivityLog>> activityLogs = new HashMap<>();
    public void log (Project project,String message){
        activityLogs.computeIfAbsent(project, p -> new LinkedList<>());
        ActivityLog log = new ActivityLog(message);
        activityLogs.get(project).addFirst(log);

    }
    public LinkedList<ActivityLog> getLogs(Project project) {
        return activityLogs.getOrDefault(project, new LinkedList<>());
    }

}
