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
    public Response allEmployees(){

        List<Employee> employees = employeeService.findAll();
        Response response = new Response(HttpStatus.OK.value(), "List of employees", System.currentTimeMillis());
        response.setDataEmployees(employees);

        return response;
    }

    @GetMapping("/employees/{employeeId}")
    public Response geEmployee(@PathVariable int employeeId){

        Employee tempEmp = employeeService.findById(employeeId);

        if(tempEmp==null)
            throw new EmployeeNotFoundException("Employee id not found: " + employeeId);

        Response response = new Response(HttpStatus.OK.value(), "Employee finded", System.currentTimeMillis());
        response.setDataEmployees(response.addEmployeeToList(tempEmp));

        return response;
    }

    // get employee searching by name
    @GetMapping("/employees/name/{name}")
    public Response findEmployeeQueryname(@PathVariable String name){

        List<Employee> employeeList = employeeService.findByQueryName(name);

        if (employeeList == null)
            throw new EmployeeNotFoundException("Employee name containing " + name + " was not found");

        Response response = new Response(HttpStatus.OK.value(), "Employee name containing " + name, System.currentTimeMillis());
        response.setDataEmployees(employeeList);

        return response;
    }

    @PutMapping("/employees")
    public Response updateEmployee(@RequestBody Employee employee){

        Employee tempEmp = employeeService.findById(employee.getId());

        if(tempEmp==null)
            throw new EmployeeNotFoundException("Employee id not found: " + employee.getId());

        tempEmp = employeeService.save(employee);
        Response response = new Response(HttpStatus.OK.value(), "Employee id " + employee.getId() + " just updated.", System.currentTimeMillis());
        response.setDataEmployees(response.addEmployeeToList(tempEmp));

        return response;
    }

    // save employee
    @PostMapping("/employees")
    public Response saveEmployee(@RequestBody Employee employee){
         Employee tempEmp = employeeService.save(employee);

         Response response = new Response(HttpStatus.OK.value(), "Employee saved.", System.currentTimeMillis());
         response.setDataEmployees(response.addEmployeeToList(tempEmp));

         return response;
    }

    //delete employee
    @DeleteMapping("/employees/{idEmployee}")
    public Response deleteEmployee(@PathVariable int idEmployee){

        Employee employee = employeeService.findById(idEmployee);

        if (employee == null)
            throw new EmployeeNotFoundException("Employee id not found: " + idEmployee);

        employeeService.delete(idEmployee);
        Response response = new Response(HttpStatus.OK.value(), "Employee id deleted: " + idEmployee, System.currentTimeMillis());
        response.setDataEmployees(employeeService.findAll());

        return response;
    }


}
