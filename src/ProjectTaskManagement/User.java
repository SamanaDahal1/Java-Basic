package ProjectTaskManagement;

public class User  {
    private int id;
    private String name;
    private Role role;

    User(int id , String name, Role role){
        this.id=id;
        this.name=name;
        this.role= role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User:"+"\n"+getId()+"\n"+getName()+"\n"+getRole();
    }
}
