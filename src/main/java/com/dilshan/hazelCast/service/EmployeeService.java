package com.dilshan.hazelCast.service;

import com.dilshan.hazelCast.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Integer employeeId);

    Employee deleteEmployee(Integer employeeId);
}
