package CoreJavaRevision.EmployeeManagement;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    Map<Integer,Employee> listEmployee=new HashMap<>();
    void addEmployee(Employee employee){
        listEmployee.put(employee.getId(),employee);
    }
    Employee  searchId (int id){
        return listEmployee.get(id);
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
