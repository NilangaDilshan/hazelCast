package com.dilshan.hazelCast.controllers;

import com.dilshan.hazelCast.entities.Employee;
import com.dilshan.hazelCast.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(
                this.employeeService.getAllEmployees(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/employeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId) {
        return new ResponseEntity<>(
                this.employeeService.getEmployeeById(employeeId),
                HttpStatus.OK);
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(
                this.employeeService.createEmployee(employee),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/employeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> delete(@PathVariable Integer employeeId) {
        return new ResponseEntity<Employee>(
                this.employeeService.deleteEmployee(employeeId),
                HttpStatus.OK);
    }
}
