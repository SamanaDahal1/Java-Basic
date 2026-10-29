package CoreJavaRevision.EmployeeManagement;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.addEmployee(new Employee(1,"Sashi","IT",90000));
            employeeService.addEmployee(new Employee(2,"ashi","IT",85000));
            employeeService.addEmployee(new Employee(3,"Sas","Finance",45500));
        }
        catch (DuplicateEmployeeException e){
           System.out.println( e.getMessage());
        }
        employeeService.displayAllEmp();
        Optional<Employee> employee =employeeService.searchId(10);
        employee.ifPresentOrElse(i->{System.out.println("--Found Employee--" +
                "\nEmployee Id: "+i.getId()+
                "\nEmployee Name: "+i.getName()+
                "\nDepartment: "+i.getDepartment()+
                "\nSalary: "+i.getSalary()+"\n");},()->{System.out.println("Employee Not Found\n");});

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
        double totalSalary=employeeService.totalSalary();
        System.out.println("--Total Salary of all--\n"+totalSalary+"\n");
        double averageSalary = employeeService.averageSalary();
        System.out.println("--Average Salary--\n"+averageSalary+"\n");
        Employee highestSalary = employeeService.highestSalary();
        if(highestSalary!=null){
            System.out.println("--Highest Salary--"+"\nEmployee Name: "+highestSalary.getName()+"\nSalary: "+highestSalary.getSalary());
        }
        else {
            System.out.println("No Employees Found");
        }
        List<Employee> sortedBySalary = employeeService.sortedEmpSalary();
        System.out.println("\n--Sorting By Salary--");
        sortedBySalary.forEach((emp) -> System.out.println("Employee Name: "+emp.getName()+
                "\nEmployee Salary: "+emp.getSalary()+"\n"));
        Map<String,List<Employee>> groupByDepartment = employeeService.groupByDep();
        System.out.println("\n--Grouping By Department--");
        groupByDepartment.forEach((key ,value)-> System.out.println("Department: "+key+
                "\nEmployee Name: "+value.stream().map(Employee::getName).toList()+"\n"));
        employeeService.increaseSalary("IT",15);
        System.out.println("\n--Increase Salary --");
        employeeService.displayAllEmp();
        System.out.println("\n--Removing Employee Detail By Id--");
        employeeService.removeById(2);
        employeeService.displayAllEmp();
        double salary = 80000;
        String department="IT";
        List<Employee> result = employeeService.searchEmployees(i->i.getDepartment().equalsIgnoreCase(department)&&i.getSalary()>salary);
        System.out.println("--Search--");
        result.forEach((emp) -> {
            System.out.println("Employee Name: "+emp.getName()+
                    "\nEmployee Salary: "+ emp.getSalary()+"\n");
        });
        Predicate<Employee> departmentCondition =i->i.getDepartment().equalsIgnoreCase(department);
        Predicate<Employee> salaryCondition =i->i.getSalary()>salary;
        List<Employee> result1=employeeService.searchEmployees(departmentCondition.and(salaryCondition));
    }
}
