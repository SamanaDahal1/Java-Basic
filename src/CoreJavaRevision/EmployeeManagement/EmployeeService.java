package CoreJavaRevision.EmployeeManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void displayAllEmp(){
        listEmployee.forEach((integer, employee) -> {
            System.out.println("Employee Id: "+employee.getId()+
                    "\nEmployee Name: "+employee.getName()+
                    "\nDepartment: "+employee.getDepartment()+
                    "\nSalary: "+employee.getSalary()+"\n");
        });
    }
}
