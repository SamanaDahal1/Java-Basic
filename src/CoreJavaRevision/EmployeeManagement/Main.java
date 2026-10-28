package CoreJavaRevision.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee(1,"Sashi","IT",90000));
        employeeService.addEmployee(new Employee(2,"ashi","IT",85000));
        employeeService.addEmployee(new Employee(3,"Sas","Finance",45500));
        employeeService.displayAllEmp();
    }
}
