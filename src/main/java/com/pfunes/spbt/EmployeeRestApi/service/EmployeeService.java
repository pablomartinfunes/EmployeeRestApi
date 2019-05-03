package com.pfunes.spbt.EmployeeRestApi.service;

import com.pfunes.spbt.EmployeeRestApi.dao.EmployeeRepository;
import com.pfunes.spbt.EmployeeRestApi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Transactional
    public List<Employee> findByQueryName(String letters){
       return employeeRepository.findEmployeeByFirstNameContains(letters);

    }

    @Transactional
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    @Transactional
    public void delete(int id){
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee findById(int id){
        return employeeRepository.findById(id);
    }
}
