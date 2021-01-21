package ee.bcs.valiit.tasks.solution.controller;


import ee.bcs.valiit.tasks.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("solution")
@RestController
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();

    //http://localhost:8080/solution/employee/name/id
    @GetMapping("employee/{name}/{id}")
    public Employee employee(@PathVariable("name") String name, @PathVariable("id") String id) {
        Employee employee = new Employee();
        employee.setName("Kristian");
        employee.setId("1");
        return employee;
    }

    //http://localhost:8080/solution/employee/
    @PostMapping("employee")
    public Employee employee2(@RequestBody Employee name) {
        System.out.println(name.getName());
        System.out.println(name.getId());
        return name;
    }

    //http://localhost:8080/solution/addEmployee/
    @PostMapping("addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
    }

    //http://localhost:8080/solution/showEmployee
    @GetMapping("showEmployee")
    public List<Employee> showEmployee() {
        return employeeList;
    }

    //http://localhost:8080/solution/solution/1
    @GetMapping("solution/{id}")
    //url otsib id j2rgi, nt 1, loogilised sulnud ainult siis kui mingi parameeter
    public Employee id(@PathVariable("id") int idVariable) { //PathVariable sobib ID-le
        return employeeList.get(idVariable);
    }

    @PutMapping("solution/{replaceEmployee}")
    public void replaceEmployee(@RequestBody Employee employee, @PathVariable("replaceEmployee") int idVariable) { //body siis peab olema def postmanis raw-json
        employeeList.set(idVariable, employee);
    }
//http://localhost:8080/solution/solution/2
    @DeleteMapping("solution/{deleteEmployee}")
    public void deleteEmployee(@PathVariable("deleteEmployee") int idVariable) {
        employeeList.remove(idVariable);
    }

}
