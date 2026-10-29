package CoreJavaRevision.EmployeeManagement;

import java.util.*;

public class EmployeeService {
    Map<Integer,Employee> listEmployee=new HashMap<>();
    void addEmployee(Employee employee){
        listEmployee.put(employee.getId(),employee);
    }
    Employee  searchId (int id){
        return listEmployee.get(id);
    }
    List<Employee> searchDepartment(String department){
        List<Employee> list = listEmployee.values().stream()
                .filter(i -> i.getDepartment().equalsIgnoreCase(department))
                .toList();

        return list;
    }
    List<Employee> greaterSalary(double salary){
        List<Employee> list = listEmployee.values().stream()
                .filter(i -> i.getSalary() > salary)
                .toList();
        return list;
    }
    double totalSalary(){
        return listEmployee.values().stream()
                .mapToDouble(emp -> emp.getSalary())
                .sum();
    }
    double averageSalary(){
         return listEmployee.values().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                 .orElse(0.0);
    }
    Employee highestSalary(){
        return listEmployee.values().stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    void displayAllEmp(){
        listEmployee.forEach((integer, employee) -> {
            System.out.println("Employee Id: "+employee.getId()+
                    "\nEmployee Name: "+employee.getName()+
                    "\nDepartment: "+employee.getDepartment()+
                    "\nSalary: "+employee.getSalary()+"\n");
        });
    }

}
