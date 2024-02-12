package com.dilshan.hazelCast.service.impl;

import com.dilshan.hazelCast.entities.Employee;
import com.dilshan.hazelCast.repository.EmployeeRepo;
import com.dilshan.hazelCast.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Cacheable("employees")
    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }

    @Cacheable(value = "employees", key = "#employeeId")
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return this.employeeRepo.findById(employeeId).orElseThrow(IllegalArgumentException::new);
    }

    @CachePut(value = "employees")
    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    @CacheEvict(value = "employees", key = "#employeeId")
    @Override
    public Employee updateEmployee(Employee employee, Integer employeeId) {
        Employee existingEmployee = this.employeeRepo.findById(employeeId).orElseThrow(IllegalArgumentException::new);

        return null;
    }

    @CacheEvict(value = "employees", key = "#employeeId")
    @Override
    public Employee deleteEmployee(Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(IllegalArgumentException::new);
        this.employeeRepo.deleteById(employeeId);
        return employee;
    }

    @PostConstruct
    public void addData() {
        this.employeeRepo.save(Employee.builder().firstName("Dil").lastName("Wije").age(34).build());
        this.employeeRepo.save(Employee.builder().firstName("Nan").lastName("Wije").age(68).build());
        this.employeeRepo.save(Employee.builder().firstName("Tharu").lastName("Wije").age(36).build());
    }
}
