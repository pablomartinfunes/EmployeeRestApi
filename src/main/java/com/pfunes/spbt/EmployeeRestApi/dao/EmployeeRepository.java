package com.pfunes.spbt.EmployeeRestApi.dao;

import com.pfunes.spbt.EmployeeRestApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByFirstNameContains(String letters);

    Employee findById(int id);
}
