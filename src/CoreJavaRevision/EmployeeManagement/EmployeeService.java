package CoreJavaRevision.EmployeeManagement;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    Map<Integer,Employee> listEmployee=new HashMap<>();
    void addEmployee(Employee employee)throws DuplicateEmployeeException{
        if(listEmployee.containsKey(employee.getId())){
            throw new DuplicateEmployeeException("This ID Employee Already Exist");
        }
        else {
        listEmployee.put(employee.getId(),employee);
        }
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
                .mapToDouble(Employee::getSalary)
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
    List<Employee> sortedEmpSalary(){
       return listEmployee.values().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
    }
    Map<String,List<Employee>> groupByDep(){
        return listEmployee.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
    void increaseSalary(String department,double percentage){
        listEmployee.values().stream()
                .filter(i -> i.getDepartment().equalsIgnoreCase(department))
                .forEach(employee -> employee.setSalary(employee.getSalary()+employee.getSalary()*percentage/100));
    }
    void removeById (int id){
        listEmployee.remove(id);

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
