package com.pfunes.spbt.EmployeeRestApi.rest;

import com.pfunes.spbt.EmployeeRestApi.entity.Employee;
import com.pfunes.spbt.EmployeeRestApi.exception.EmployeeNotFoundException;
import com.pfunes.spbt.EmployeeRestApi.exception.Response;
import com.pfunes.spbt.EmployeeRestApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    // get list of employees
    @GetMapping("/employees")
    public List<Employee> allEmployees(){

        List<Employee> employees = employeeService.findAll();

        return employees;
    }

    // get employee searching by name
    @GetMapping("/employees/name/{name}")
    public List<Employee> findEmployeeQueryname(@PathVariable String name){
        return employeeService.findByQueryName(name);
    }

    // save employee
    @PostMapping("/employees")
    public Response saveEmployee(@RequestBody Employee employee){
         employeeService.save(employee);
         return new Response(HttpStatus.OK.value(), "Employee saved.", System.currentTimeMillis());
    }

    //delete employee
    @DeleteMapping("/employees/{idEmployee}")
    public Response deleteEmployee(@PathVariable int idEmployee){

        Employee employee = employeeService.findById(idEmployee);

        if (employee == null)
            throw new EmployeeNotFoundException("Employee id not found: " + idEmployee);

        employeeService.delete(idEmployee);

        return new Response(HttpStatus.OK.value(), "Employee id deleted: " + idEmployee, System.currentTimeMillis());
    }


}
