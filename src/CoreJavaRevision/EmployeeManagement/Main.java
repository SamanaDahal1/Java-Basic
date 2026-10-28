package CoreJavaRevision.EmployeeManagement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee(1,"Sashi","IT",90000));
        employeeService.addEmployee(new Employee(2,"ashi","IT",85000));
        employeeService.addEmployee(new Employee(3,"Sas","Finance",45500));
        employeeService.displayAllEmp();
        Employee employee =employeeService.searchId(1);
        System.out.println("--Found Employee--" +
                "\nEmployee Id: "+employee.getId()+
                "\nEmployee Name: "+employee.getName()+
                "\nDepartment: "+employee.getDepartment()+
                "\nSalary: "+employee.getSalary()+"\n");
        List<Employee> employeeList=employeeService.searchDepartment("iT");
        System.out.println("--Department Search--");
        employeeList.forEach((emp) -> {
            System.out.println("Employee Id: "+emp.getId()+
                    "\nEmployee Name: "+emp.getName()+"\n");
        });
        List<Employee> salaryGreater=employeeService.greaterSalary(60000);
        System.out.println("--Salary Search--");
        salaryGreater.forEach((emp) -> {
            System.out.println("Employee Name: "+emp.getName()+
                    "\nEmployee Salary: "+ emp.getSalary()+"\n");
        });

    }
}
