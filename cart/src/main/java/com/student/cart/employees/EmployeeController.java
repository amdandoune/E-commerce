package com.student.cart.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

}
