package ProjectTaskManagement;

import java.util.HashSet;
import java.util.Set;

public class Project {
    private int id;
    private String name;
    private Set<User> members;

    public Project(int id,String name){
        this.id=id;
        this.name=name;
        members = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getMembers() {
        return members;
    }
    public void addMember(User user){
        members.add(user);
    }

    @Override
    public String toString() {
        return "Project:\n"+getId()+"\n"+getName();
    }
}
