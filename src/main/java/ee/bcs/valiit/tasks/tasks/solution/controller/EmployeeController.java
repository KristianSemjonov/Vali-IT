package ee.bcs.valiit.tasks.tasks.solution.controller;


import ee.bcs.valiit.tasks.tasks.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("solution")
@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    List<Employee> employeeList = new ArrayList<>();

    //http://localhost:8080/solution/employee/name/id
    @GetMapping("employee/{name}/{id}")
    public Employee employee(@PathVariable("name") String name, @PathVariable("id") String id) {
        Employee employee = new Employee();
        employee.setName("Kristian");
        employee.setId("1");

        return employee;
    }

    //http://localhost:8080/solution/employee/ enam ei toimi
    //http://localhost:8081/solution/employee?name=Kiku&address=Tallinn
    @PostMapping("employee")
    public String employee2(@RequestParam("name") String name, @RequestParam("address") String address) {

        Employee employeeNew = new Employee();
        employeeNew.setAddress(address);
        employeeNew.setName(name);

        String sql = "INSERT INTO employee (name, address) values (:nameParameter,:addressParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("addressParameter", employeeNew.getAddress());
        paramMap.put("nameParameter", employeeNew.getName());
        jdbcTemplate.update(sql, paramMap);
        return "Employee added";

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
